package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 创作者: 陈文震
 * 创作日期: 2020年07月21日  周二  13:16
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
// 在企业中，所有pojo都会序列化！SpringBoot
public class User implements Serializable {

    private String name;
    private int age;

}
