package com.kuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 创作者: 陈文震
 * 创作日期: 2020年07月11日  周六  15:59
 */
public class MyLocaleResolver implements LocaleResolver {
    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的语言参数
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault(); // 如果没有就是用默认的
        // 如果请求的链接携带了国际化参数
        if (!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            // 国家，地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
    // 自定义的国际化组件就生效了
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
