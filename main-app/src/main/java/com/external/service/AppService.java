package com.external.service;

import com.external.dto.OrderResponseDTO;
import com.external.client.RestaurantServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;

    public String greeting() {
        return "Welcome to Swiggy App Service";
    }

    public OrderResponseDTO checkOrderStatus(String orderId) {
        return restaurantServiceClient.fetchOrderStatus(orderId);
    }
}
