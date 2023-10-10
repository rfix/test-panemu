package com.mainapp.service;

import com.mainapp.client.ExternalServiceClient;
import com.mainapp.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private ExternalServiceClient externalServiceClient;

    public List<TodoDto> todoById(Long id) {
        return externalServiceClient.fetchTodoById(id);
    }

}
