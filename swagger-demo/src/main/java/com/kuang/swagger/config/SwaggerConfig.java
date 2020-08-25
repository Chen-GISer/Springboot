package com.kuang.swagger.config;

import com.kuang.swagger.controller.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 创作者: 陈文震
 * 创作日期: 2020年07月19日  周日  14:04
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment){

        Profiles profiles = Profiles.of("dev","test");

        // 获取项目的环境
        boolean b = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("狂神")
                .enable(true) // enable是否启动Swagger,如果为false，则Swagger不能在浏览器中访问
                .select()
                // RequestHandlerSelectors，配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.kuang.swagger.controller"))
                .build(); // build
    }

    // 配置swagger信息=apiInfo
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("陈文震", "http://localhost:8080/", "Wenzhen_Kris@foxmail.com");

        return new ApiInfo(
                "狂神的SwaggerAPI文档",
                "即使再小的帆也能远航",
                "v1.0",
                "http://localhost:8080/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
