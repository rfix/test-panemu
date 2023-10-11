package com.api3.config;

import com.api3.repository.PostRepository;
import com.api3.dto.PostDto;
import com.api3.entity.Post;
import com.api3.service.Api3Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Configuration
@Slf4j
public class Config {

    @Autowired
    private Api3Service service;

    @Bean
    @LoadBalanced
    public RestTemplate template(){
        return new RestTemplate();
    }

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    RestTemplate template = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public List<PostDto> fetchUsers() throws JsonProcessingException {
        log.info("================= fetch post data ===================");
        ResponseEntity<String> response = template.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                String.class
        );
        PostDto[] responseData = objectMapper.readValue(response.getBody(), PostDto[].class);
        List<PostDto> postDtoList = Arrays.stream(responseData).toList();
        log.info("response data : {} ", response.getBody());
        service.savePost(postDtoList);
        return postDtoList;
    }

}
