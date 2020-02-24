package com.example.springbootdemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: springboot-demo
 * @ClassName: MyExceptioin
 * @Description: 自定义异常
 * @Author: zhangdi
 * @Date: 2020年02月21日 14:27
 **/
@RestControllerAdvice
public class MyExceptioin {
    @ExceptionHandler(Exception.class)
    public String getException(HttpServletRequest request, Exception e) {
        System.out.println("******:" + e.getMessage());

        return e.getMessage();
    }
}
