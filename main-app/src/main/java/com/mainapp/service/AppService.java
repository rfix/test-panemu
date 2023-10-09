package com.mainapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mainapp.client.UserServiceClient;
import com.mainapp.dto.OrderResponseDTO;
import com.mainapp.client.ExternalServiceClient;
import com.mainapp.dto.TodoDto;
import com.mainapp.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private ExternalServiceClient externalServiceClient;
    @Autowired
    private UserServiceClient userServiceClient;

    public List<TodoDto> todoById(Long id) {
        return externalServiceClient.fetchTodoById(id);
    }

    public List<UserDto> userById(Long id) throws JsonProcessingException {
         List<UserDto> userDtos = userServiceClient.fetchUsers();
         return userDtos.stream().filter(userDto -> userDto.getId().equals(id)).toList();
    }
}
