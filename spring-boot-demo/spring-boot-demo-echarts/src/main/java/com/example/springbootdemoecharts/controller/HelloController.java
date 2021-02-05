package com.example.springbootdemoecharts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: HelloController
 * @Description: hello 控制器
 * @Author: zhangdi
 * @Date: 2020年04月23日 14:47
 **/
@Controller
@RequestMapping(value = "shello")
public class HelloController {
    @RequestMapping(value = "index")
    public String index(ModelMap map) {
        return "index";
    }
}
