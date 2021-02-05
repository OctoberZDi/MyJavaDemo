package com.example.springbootdemojwt.controller;

import com.example.springbootdemojwt.data.User;
import com.example.springbootdemojwt.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserController
 * @Description: usercontroller
 * @Author: zhangdi
 * @Date: 2020年05月16日 10:37
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {
    UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "getById/{id}")
    public User getUserById(@PathVariable("id") String id) throws InterruptedException {
        //Thread.sleep(5000L);
        User user = userService.getUserById(id);
        if (null == user) {
            throw new RuntimeException("当前id对应用户信息不存在！");
        }

        return user;
    }
}
