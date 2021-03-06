package com.springBoot.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Value("${welcome.message}")
    String welcomeMessage;

    @GetMapping("/")
    public String getMessage()
    {
        return welcomeMessage;
    }
}
