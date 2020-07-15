package com.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class Test {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/gettest")
    public String getTest() {
        String object = restTemplate.getForObject("http://user-service/user/1024", String.class);
        return "goods is ok" + object;
    }
}
