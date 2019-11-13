package com.by.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class Exception404 {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map exception() {
        Map map = new HashMap();
        map.put("msg", "异常了");
        map.put("code", "400");
        return map;
    }
}
