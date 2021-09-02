package com.mall.controller;

import com.alibaba.fastjson.JSON;
import com.mall.RedisUtil;
import com.mall.entity.UserEntity;
import com.mall.exception.MallException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
@Api(value = "swagger测试")
public class Test {

    private static final String serviceName = "http://WJ-GOODS";

    @PostMapping("/hello")
    @ApiOperation(value = "测试方法",notes = "获取数据库用户详情")
    public String getUser(@ApiParam(value = "用户id") @RequestParam("userid") String userid) {
//        UserEntity userEntity = mapper.selectUser(userid);
//        if(userEntity == null){
//            throw new MallException(3210,"未查询到数据！");
//        }
//        return JSON.toJSONString(userEntity);
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
