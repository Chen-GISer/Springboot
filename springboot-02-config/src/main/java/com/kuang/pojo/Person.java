package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 创作者: 陈文震
 * 创作日期: 2020年07月09日  周四  10:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Validated //数据校验
@ConfigurationProperties(prefix = "person")
public class Person {
    @Email(message="邮箱错了")
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
