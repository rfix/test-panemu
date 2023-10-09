package com.mainapp.service;

import com.mainapp.dto.OrderResponseDTO;
import com.mainapp.client.ExternalServiceClient;
import com.mainapp.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private ExternalServiceClient externalServiceClient;

    public String greeting() {
        return "Welcome to Swiggy App Service";
    }

    public OrderResponseDTO checkOrderStatus(String orderId) {
        return externalServiceClient.fetchOrderStatus(orderId);
    }

    public List<TodoDto> todoById(Long id) {
        return externalServiceClient.fetchTodoById(id);
    }
}
