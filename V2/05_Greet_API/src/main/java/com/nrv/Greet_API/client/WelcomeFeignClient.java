package com.nrv.Greet_API.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "WELCOME-API")
public interface WelcomeFeignClient {

    @GetMapping("/welcome")
    public String getWelcomeMsg();
}
