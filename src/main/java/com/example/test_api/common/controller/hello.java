package com.example.test_api.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @GetMapping("/hello")
    String hello() {
        return "hello test-api";
    }
}
