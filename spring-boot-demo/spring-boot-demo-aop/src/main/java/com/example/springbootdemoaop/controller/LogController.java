package com.example.springbootdemoaop.controller;

import com.example.springbootdemoaop.annotation.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: LogController
 * @Description: log controller
 * @Author: zhangdi
 * @Date: 2020年04月08日 17:05
 **/
@RequestMapping(value = "test")
@RestController
public class LogController {
    @RequestMapping(value = "1")
    @Log
    public String log1() {
        return "1";
    }

    @Log
    @RequestMapping(value = "2")
    public String log2() {
        return "2";
    }
}
