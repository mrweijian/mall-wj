package com.mall.aop;

import exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(value = "com.mall")
public class MyExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MyException.class)
    public Map<String,String> errorResult(MyException e, HttpServletResponse response){
        Map<String,String> errMap = new HashMap<>();
        //errMap.put(e.getCode(),e.getMsg());
        try {
            response.sendError(e.getCode(),e.getMsg());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return errMap;
    }
}
