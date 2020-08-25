package com.kuang.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 创作者: 陈文震
 * 创作日期: 2020年07月15日  周三  18:02
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 链式编程，授权
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问，功能页只有对应有权限的人才能访问
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 没有权限，默认会到登录页
        http.formLogin();
        // 注销，开启注销功能，跳到首页
        http.csrf().disable(); // 关闭csrf功能
        http.logout().logoutSuccessUrl("/");

        // 开启记住我功能
        http.rememberMe();
    }
    // 这个必须看源码，认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 这些数据正常都应该从数据库中读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
