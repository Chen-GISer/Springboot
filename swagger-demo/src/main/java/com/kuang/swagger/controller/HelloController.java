package com.kuang.swagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创作者: 陈文震
 * 创作日期: 2020年07月19日  周日  12:22
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
