package com.external.service;

import com.external.client.TodoServiceClient;
import com.external.dto.TodoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalService {
    @Autowired
    private TodoServiceClient todoServiceClient;

    public List<TodoDto> todoById(Long userId) throws JsonProcessingException {
        List<TodoDto> todoDtoList = todoServiceClient.fetchTodos();
        return todoDtoList.stream().filter(todoDto -> todoDto.getUserId().equals(userId)).toList();
    }

}
