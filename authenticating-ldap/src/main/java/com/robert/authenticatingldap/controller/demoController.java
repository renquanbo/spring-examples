package com.robert.authenticatingldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class demoController {
    @GetMapping
    public String handleGetRequest() {
        return "Hello developer";
    }
}
