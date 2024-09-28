package com.nrv.Welcome_API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private Environment env;

    @GetMapping("/welcome")
    public String getWelcomeMsg() {

        String port = env.getProperty("server.port");

        return "Welcome To NRV Microservice (" + port + ")";
    }
}
