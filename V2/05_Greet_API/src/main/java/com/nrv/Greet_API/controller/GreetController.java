package com.nrv.Greet_API.controller;

import com.nrv.Greet_API.client.WelcomeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @Autowired
    private WelcomeFeignClient welcomeFeignClient;

    @GetMapping("/greet")
    public String getGreetMsg() {
        return "Hello Mate, This Is NRV";
    }

    @GetMapping("/welcomeFromGreet")
    public String getWelcomeFromGreet() {
        return welcomeFeignClient.getWelcomeMsg();
    }
}
