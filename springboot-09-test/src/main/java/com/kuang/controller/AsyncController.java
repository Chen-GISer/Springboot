package com.kuang.controller;

import com.kuang.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创作者: 陈文震
 * 创作日期: 2020年07月20日  周一  12:16
 */
@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;
    @RequestMapping("/hello")
    public String hello(){
        asyncService.hello();
        return "OK";
    }

}
