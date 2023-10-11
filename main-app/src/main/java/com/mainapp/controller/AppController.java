package com.mainapp.controller;

import com.mainapp.dto.TodoDto;
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

    @GetMapping("/todo/{id}")
    public List<TodoDto> getTodoById(@PathVariable Long id) {
        return service.todoById(id);
    }

    @GetMapping("/user/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return service.getUserById(userId);
    }
}
