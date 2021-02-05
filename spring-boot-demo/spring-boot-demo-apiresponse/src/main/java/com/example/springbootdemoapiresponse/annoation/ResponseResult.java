package com.example.springbootdemoapiresponse.annoation;

import java.lang.annotation.*;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ResponseResult
 * @Description: 注解，返回值包装
 * @Author: zhangdi
 * @Date: 2020年11月02日 17:58
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
