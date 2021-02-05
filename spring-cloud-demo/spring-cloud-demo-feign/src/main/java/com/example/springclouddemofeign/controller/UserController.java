package com.example.springclouddemofeign.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springclouddemofeign.feignservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserController
 * @Description: user测试控制器
 * @Author: zhangdi
 * @Date: 2020年05月23日 10:20
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {

    UserService userRestClient;

    @Autowired
    public void setUserService(UserService userRestClient) {
        this.userRestClient = userRestClient;
    }

    @RequestMapping(value = "/getStr2/{str}")
    Object getStr2(@PathVariable(value = "str") String str) {
        return userRestClient.getStr2(str);
    }

    @RequestMapping(value = "/getStr/{str}")
    String getStr(@PathVariable(value = "str") String str) {
        return userRestClient.getStr(str);
    }

    @RequestMapping(value = "/getObj")
    Object getObj(@RequestBody JSONObject object) {
        return userRestClient.getObject(object);
    }

}
