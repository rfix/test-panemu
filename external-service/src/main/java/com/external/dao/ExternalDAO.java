package com.external.dao;

import com.external.dto.ExternalResponseDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ExternalDAO {


    public ExternalResponseDTO getOrders(String orderId) {
        return generateRandomOrders().get(orderId);
    }

    private Map<String, ExternalResponseDTO> generateRandomOrders() {
        Map<String, ExternalResponseDTO> orderMap = new HashMap<>();
        orderMap.put("35fds631", new ExternalResponseDTO("35fds63", "VEG-MEALS", 1, 199, new Date(), "READY", 15));
        orderMap.put("9u71245h", new ExternalResponseDTO("9u71245h", "HYDERABADI DUM BIRYANI", 2, 641, new Date(), "PREPARING", 59));
        orderMap.put("37jbd832", new ExternalResponseDTO("37jbd832", "PANEER BUTTER MASALA", 1, 325, new Date(), "DELIVERED", 0));
        return orderMap;
    }

    public static void main(String[] args) {
        System.out.println("hyderabadi dum biryani".toUpperCase());
    }


}
