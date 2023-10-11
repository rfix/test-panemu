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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceClient {
    public static final Long CACHE_TIMEOUT = 30L;
    public static final String USER_CACHE = "userCache";
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
        log.info("response data : {} ", response.getBody());
        redisOps.set(String.format(USER_CACHE, Arrays.toString(responseData)), CACHE_TIMEOUT);
        return Arrays.stream(responseData).toList();
    }

    public List<UserDto> getUsers() throws JsonProcessingException {
        var userData = redisOps.get(USER_CACHE);
        if (Objects.isNull(userData)) {
            return List.of();
        } else {
            UserDto[] responseData = objectMapper.readValue(userData.toString(), UserDto[].class);
            return Arrays.stream(responseData).toList();
        }
    }

}
