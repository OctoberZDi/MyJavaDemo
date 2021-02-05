package com.example.springbootdemofile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: IndexController
 * @Description: index controller
 * @Author: zhangdi
 * @Date: 2020年07月06日 15:44
 **/
@Controller
public class IndexController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "index2")
    public String index2(Model model) {
        Map<String, String> userMap = new HashMap<>(16);
        userMap.put("userName", "张迪");
        userMap.put("password", "123456");
        userMap.put("age", "28");
        userMap.put("host", "www.baidu/com");
        model.addAttribute("user", userMap);

        return "index2";
    }

    @RequestMapping(value = "index3")
    public String index3(Model model) {
        model.addAttribute("name", "333333");

        return "index3";
    }
}
