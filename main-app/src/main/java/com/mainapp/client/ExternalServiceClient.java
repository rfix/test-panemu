package com.mainapp.client;

import com.mainapp.dto.OrderResponseDTO;
import com.mainapp.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class ExternalServiceClient {
    @Autowired
    private RestTemplate template;

    public List<TodoDto> fetchTodoById(Long id) {
        ResponseEntity<TodoDto[]> response = template.getForEntity("http://EXTERNAL-SERVICE/external/todo/" + id, TodoDto[].class);
        return List.of(Objects.requireNonNull(response.getBody()));
    }
}
