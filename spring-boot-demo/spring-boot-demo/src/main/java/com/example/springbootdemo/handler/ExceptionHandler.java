package com.example.springbootdemo.handler;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ExceptionHandler
 * @Description: 异常处理
 * @Author: zhangdi
 * @Date: 2020年04月30日 16:03
 **/
//@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public String exceptionHandler(HttpServletRequest request, Exception e) {
        System.out.println(request);
        System.out.println(e);
        return "";
    }
}
