package com.external.controller;

import com.external.dto.ExternalResponseDTO;
import com.external.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
