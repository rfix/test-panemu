package com.external.controller;

import com.external.dto.ExternalResponseDTO;
import com.external.dto.TodoDto;
import com.external.service.ExternalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/external")
public class ExternalController {

    @Autowired
    private ExternalService service;

    @GetMapping
    public String greetingMessage() {
        return service.greeting();
    }

    @GetMapping("/orders/status/{orderId}")
    public ExternalResponseDTO getOrder(@PathVariable String orderId) {
        return service.getOrder(orderId);
    }

    @GetMapping("/todo/{id}")
    public List<TodoDto> getDodoById(@PathVariable Long id) throws JsonProcessingException {
        return service.todoById(id);
    }

}
