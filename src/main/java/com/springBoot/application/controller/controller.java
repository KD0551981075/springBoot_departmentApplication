package com.springBoot.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping
    public String getDetails()
    {

        return  "this responce is from controller after the auto-update";


    }
}
