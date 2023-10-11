package com.api3.controller;

import com.api3.dto.PostDto;
import com.api3.dto.PostResponse;
import com.api3.service.Api3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api3")
@Slf4j
public class Api3Controller {

    @Autowired
    private Api3Service service;

    @GetMapping("/post/{userId}")
    private List<PostDto> postByUserId(@PathVariable Long userId) {
        log.info("request post");
        return service.getPostByUserId(userId);
    }

    @GetMapping("/dtest")
    public String test() {
        return "danggoroeng";
    }
}
