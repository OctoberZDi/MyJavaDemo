package com.example.springbootdemoaop.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: AopTestController
 * @Description: 测试aop的控制器
 * @Author: zhangdi
 * @Date: 2020年11月07日 10:28
 **/
@RestController
@RequestMapping(value = "/aop")
public class AopTestController {

    @GetMapping(value = "/test1/{name}")
    public String test1(@PathVariable(value = "name") String name) {
        return "hello " + name;
    }

    @PostMapping(value = "/test2/{name}")
    public String test2(@PathVariable(value = "name") String name) {
        return "hello2 " + name;
    }
}
