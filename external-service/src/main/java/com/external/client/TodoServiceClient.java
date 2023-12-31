package com.external.client;

import com.external.dto.TodoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class TodoServiceClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/todos";
    RestTemplate template = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();

    public List<TodoDto> fetchTodos() throws JsonProcessingException {
        ResponseEntity<String> response = template.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                String.class
        );
        TodoDto[] responseData = objectMapper.readValue(response.getBody(), TodoDto[].class);
        return Arrays.stream(Objects.requireNonNull(responseData)).toList();
    }

}
