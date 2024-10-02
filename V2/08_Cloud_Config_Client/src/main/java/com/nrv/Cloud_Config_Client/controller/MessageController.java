package com.nrv.Cloud_Config_Client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {

    @Value("${msg}") // from GitHub config file
    private String msg;

    @GetMapping("/")
    public String getMsg() {
        return msg;
    }
}
