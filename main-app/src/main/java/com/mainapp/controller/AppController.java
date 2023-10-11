package com.mainapp.controller;

import com.mainapp.client.ClientService;
import com.mainapp.dto.PostDto;
import com.mainapp.dto.TodoDto;
import com.mainapp.dto.UserResponse;
import com.mainapp.dto.user.UserDto;
import com.mainapp.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class AppController {

    @Autowired
    private AppService service;
    @Autowired
    private ClientService clientService;

    @GetMapping("/data")
    public List<UserResponse> getTodoById() {
        return service.getData();
    }

}
