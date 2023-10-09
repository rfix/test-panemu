package com.external.service;

import com.external.client.TodoServiceClient;
import com.external.dao.ExternalDAO;
import com.external.dto.ExternalResponseDTO;
import com.external.dto.TodoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalService {
    @Autowired
    private ExternalDAO orderDAO;
    @Autowired
    private TodoServiceClient todoServiceClient;

    public String greeting() {
        return "Welcome to Swiggy Restaurant service";
    }

    public ExternalResponseDTO getOrder(String orderId) {
        return orderDAO.getOrders(orderId);
    }

    public List<TodoDto> todoById(Long id) throws JsonProcessingException {
        List<TodoDto> todoDtoList = todoServiceClient.fetchTodos();
        return todoDtoList.stream().filter(todoDto -> todoDto.getId().equals(id)).toList();
    }

    public List<TodoDto> todoById1(Long id) throws JsonProcessingException {
        todoServiceClient.fetchTodos();
        return List.of();
    }

}
