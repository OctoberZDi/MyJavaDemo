package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: HelloController
 * @Description: 测试hello控制器
 * @Author: zhangdi
 * @Date: 2020年02月23日 14:13
 **/
@RestController
// 解决跨域 方式3 注解 局部跨域
//@CrossOrigin
@RequestMapping(value = "test")
public class HelloController {
    // 解决跨域方式4 局部跨域
    //@CrossOrigin(value = "http://localhost:8080")
    @RequestMapping(value = "hello")
    public String hello(HttpServletResponse response) {
        //  解决跨域方式5 局部跨域 手工设置响应头
        // response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        return "hello world...";
    }
}
