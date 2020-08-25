package com.kuang.config;

import com.kuang.pojo.User;
import com.kuang.service.UserService;
import jdk.nashorn.internal.parser.Token;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 创作者: 陈文震
 * 创作日期: 2020年07月17日  周五  11:47
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>认证doGetAuthorizationInfo");

        UsernamePasswordToken userToken =(UsernamePasswordToken) token;

        // 连接真实的数据库
        User user = userService.queryUserByName(userToken.getUsername());

        if (user==null){ // 没有这个人
            return null;
        }

        // 密码认证，shiro做~
        return new SimpleAuthenticationInfo("",user.getPwd(),"");
    }
}
