package com.mainapp.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mainapp.dto.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserServiceClient {
    public static final Long CACHE_TIMEOUT = 30L;
    public static final String USER_CACHE = "userCache-user-%s";
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    @Autowired
    private ValueOperations<String, Object> redisOps;
    RestTemplate template = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();

    public List<UserDto> fetchUsers() throws JsonProcessingException {
        log.info("================= fetch user data ===================");
        ResponseEntity<String> response = template.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                String.class
        );
        UserDto[] responseData = objectMapper.readValue(response.getBody(), UserDto[].class);
        List<UserDto> userDtoList = Arrays.stream(responseData).toList();
        userDtoList.forEach(userDto -> {
            try {
                redisOps.set(String.format(USER_CACHE, userDto.getId()), objectMapper.writeValueAsString(userDto), CACHE_TIMEOUT, TimeUnit.MINUTES);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        log.info("response data : {} ", response.getBody());
        return Arrays.stream(responseData).toList();
    }

    public UserDto fetchUsersById(Long userId) throws JsonProcessingException {
        String key = String.format(USER_CACHE, userId);
        var userData = redisOps.get(key);
        log.info("userData : {} ", userData);
        if (Objects.isNull(userData)) {
            return UserDto.builder().build();
        } else {
            return objectMapper.readValue(userData.toString(), UserDto.class);
        }
    }

}
