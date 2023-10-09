package com.mainapp.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mainapp.dto.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class UserServiceClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    RestTemplate template = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();

    public List<UserDto> fetchUsers() throws JsonProcessingException {
        ResponseEntity<String> response = template.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                String.class
        );
        UserDto[] responseData = objectMapper.readValue(response.getBody(), UserDto[].class);
        return Arrays.stream(Objects.requireNonNull(responseData)).toList();
    }


}
