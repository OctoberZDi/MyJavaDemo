package com.example.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: HelloWorldController
 * @Description: 测试 helloworld
 * @Author: zhangdi
 * @Date: 2020年04月02日 14:10
 **/
@RequestMapping(value = "test")
@RestController
public class HelloWorldController {

    @LoginRequired(loginSuccess = false, userIds = {"张迪", "朱玉", "小满"})
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String test(@RequestHeader Map<String, String> headers) {
        System.out.println("=============");
        headers.entrySet().stream().forEach(e -> System.out.println(e.toString()));
        headers.keySet().stream().forEach(e -> System.out.println(e + "#" + headers.get(e)));
        System.out.println("=============");
        return "Hello world...";
    }

    @LoginRequired(loginSuccess = true)
    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String test1() {
        return "Hello world1...";
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public String test2() {
        return "Hello world2...";
    }

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    public String test3(@RequestParam String name, @RequestParam String password) {
        return "UserName:" + name + " Password:" + password;
    }

    @RequestMapping(value = "hello4", method = RequestMethod.POST)
    public String test4(@RequestParam Map<String, String> params) {
        return params.keySet().stream().map(e -> e + "=" + params.get(e)).collect(Collectors.joining("、"));
    }

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "getSession")
    public String getSession(HttpSession httpSession) {
        System.out.println(httpSession.getAttribute("userInfo"));

        return (String) httpSession.getAttribute("userInfo");
    }

    @RequestMapping(value = "setSession/{name}")
    public String setSession(@PathVariable(value = "name") String name, HttpSession httpSession) {
        httpSession.setAttribute("userInfo", "name=" + name + "、port=" + serverPort);
        return "success";
    }

    @RequestMapping(value = "testEx")
    public String testEx() {
        String[] names = new String[]{"tom", "jerry", "hankes"};
        Object aa = null;
        Assert.notNull(aa, "aa is null");
        return "";
    }

    @RequestMapping(value = "hello5", method = RequestMethod.POST)
    public String testHello5(@RequestBody JSONObject object) {
        return object.toString();
    }
}
