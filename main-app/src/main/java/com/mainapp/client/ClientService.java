package com.mainapp.client;

import com.mainapp.constant.ServicePathConstant;
import com.mainapp.dto.PostDto;
import com.mainapp.dto.PostResponse;
import com.mainapp.dto.TodoClientResponse;
import com.mainapp.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class ClientService {
    @Autowired
    private RestTemplate template;

    public List<TodoDto> fetchTodoById(Long userId) {
        ResponseEntity<TodoDto[]> response = template.getForEntity(ServicePathConstant.TODO_URL + userId, TodoDto[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public List<PostDto> fetchPostByUserId(Long userId) {
        ResponseEntity<PostDto[]> response = template.getForEntity(ServicePathConstant.POST_URL + userId, PostDto[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
