package com.example.springbootdemo.annotation;

import java.lang.annotation.*;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: LoginRequired
 * @Description: 登录注解
 * @Author: zhangdi
 * @Date: 2021年02月02日 15:08
 **/
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
    boolean loginSuccess() default true;

    String[] userIds() default {};
}
