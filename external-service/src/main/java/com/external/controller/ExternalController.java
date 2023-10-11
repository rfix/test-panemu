package com.external.controller;

import com.external.dto.TodoDto;
import com.external.service.ExternalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/external")
@Slf4j
public class ExternalController {

    @Autowired
    private ExternalService service;


    @GetMapping("/todo/{userId}")
    public List<TodoDto> getDodoById(@PathVariable Long userId) throws JsonProcessingException {
        log.info("request todo");
        return service.todoById(userId);
    }

}
