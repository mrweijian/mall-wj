package com.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(value = "swagger测试")
public class Test {

    private static final String serviceName = "http://WJ-GOODS";

    @PostMapping("/hello")
    @ApiOperation(value = "测试方法",notes = "获取数据库用户详情")
    public String getUser(@ApiParam(value = "用户id") @RequestParam String userid) {
        return null;
    }

    @GetMapping("/getgood")
    //@HystrixCommand(fallbackMethod="defaultfallback")
    @ApiOperation(value = "获取产品信息")
    public String getGood() {
        System.out.println("success");
        return "ok11";
        //return restTemplate.getForObject(serviceName+"/test/gettest",String.class);
    }

    @GetMapping("/setRedisTest")
    public String setRedisTest(){
        //redisUtil.set("weijian","hello redis");
        return "SUCCESS";
    }



    public String defaultfallback(){
        return "断路器打开";
    }




}
