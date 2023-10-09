package com.external.service;

import com.external.dao.ExternalDAO;
import com.external.dto.ExternalResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalService {
    @Autowired
    private ExternalDAO orderDAO;

    public String greeting() {
        return "Welcome to Swiggy Restaurant service";
    }

    public ExternalResponseDTO getOrder(String orderId) {
        return orderDAO.getOrders(orderId);
    }
}
