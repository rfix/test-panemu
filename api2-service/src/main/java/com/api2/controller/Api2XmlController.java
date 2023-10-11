package com.api2.controller;

import com.api2.dto.PostDto;
import com.api2.service.Api2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/xml",
        produces = "application/xml")
public class Api2XmlController {
    @Autowired
    private Api2Service service;

    @GetMapping(value = "/post", produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<PostDto>> getPostXmlResponse() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(service.getPostData(), headers, HttpStatus.OK);
    }
}
