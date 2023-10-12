package com.api2.controller;

import com.api2.dto.PostDto;
import com.api2.service.Api2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
@Slf4j
public class Api2Controller {

    @Autowired
    private Api2Service service;

    @GetMapping(value = "/post/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PostDto> postByUserId(@PathVariable Long userId) {
        log.info("request post");
        return service.getPostByUserId(userId);
    }

    @GetMapping(value = "/post", produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<PostDto>> getPostXmlResponse() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(service.getPostData(), headers, HttpStatus.OK);
    }

    @GetMapping(value = "/test")
    public String test() {
        log.info("request test");
        return "danggoreng";
    }

}
