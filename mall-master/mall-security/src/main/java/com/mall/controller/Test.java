package com.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @RequestMapping("/testSecurity")
    public String testSecurity(){
        return "SUCCESS";
    }
}
