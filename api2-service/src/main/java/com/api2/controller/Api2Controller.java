package com.api2.controller;

import com.api2.dto.PostDto;
import com.api2.service.Api2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
@Slf4j
public class Api2Controller {

    @Autowired
    private Api2Service service;

    @GetMapping("/post/{userId}")
    public List<PostDto> postByUserId(@PathVariable Long userId) {
        log.info("request post");
        return service.getPostByUserId(userId);
    }

}
