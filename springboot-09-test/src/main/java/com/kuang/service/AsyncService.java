package com.kuang.service;

import org.springframework.stereotype.Service;

/**
 * 创作者: 陈文震
 * 创作日期: 2020年07月20日  周一  12:06
 */
@Service
public class AsyncService {

    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理......");
    }

}
