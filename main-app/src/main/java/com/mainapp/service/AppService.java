package com.mainapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mainapp.client.ClientService;
import com.mainapp.client.UserServiceClient;
import com.mainapp.dto.PostDto;
import com.mainapp.dto.TodoDto;
import com.mainapp.dto.UserResponse;
import com.mainapp.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    @Autowired
    private ClientService clientService;
    @Autowired
    private UserServiceClient userServiceClient;

    public List<TodoDto> todoByUserId(Long userId) {
        return clientService.fetchTodoById(userId);
    }

    public List<PostDto> postByUserId(Long userId) {
        return clientService.fetchPostByUserId(userId);
    }

    public UserDto getUserById(Long userId) {
        try {
            return userServiceClient.fetchUsersById(userId);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserResponse> getData() {
        Long userId = 1L;
        List<UserResponse> resultList = new ArrayList<>();
        UserDto userDto = getUserById(userId);
        List<TodoDto> todoDtoList = todoByUserId(userId);
        List<PostDto> postDtoList = postByUserId(userId);
        resultList.add(
                UserResponse.builder()
                        .id(userDto.getId())
                        .name(userDto.getName())
                        .username(userDto.getUsername())
                        .email(userDto.getEmail())
                        .address(userDto.getAddress())
                        .phone(userDto.getPhone())
                        .website(userDto.getWebsite())
                        .company(userDto.getCompany())
                        .todos(todoDtoList.stream().limit(2L).toList())
                        .posts(postDtoList.stream().limit(2L).toList())
                        .build()
        );
        return resultList;
    }

}
