package com.mainapp.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class MainAppConfig {

    @Bean
    @LoadBalanced
    public RestTemplate template(){
        return new RestTemplate();
    }

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    RestTemplate template = new RestTemplate();
//    ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    @Cacheable(value = "userCache")
    public void fetchUsers() throws JsonProcessingException {
        log.info("================= fetch user data ===================");
        ResponseEntity<String> response = template.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                String.class
        );
//        UserDto[] responseData = objectMapper.readValue(response.getBody(), UserDto[].class);
        log.info("response data : {} ", response.getBody());
    }
}
