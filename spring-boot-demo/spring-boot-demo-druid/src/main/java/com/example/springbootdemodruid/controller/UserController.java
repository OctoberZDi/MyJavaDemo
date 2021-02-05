package com.example.springbootdemodruid.controller;

import com.example.springbootdemodruid.data.User;
import com.example.springbootdemodruid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserController
 * @Description: usercontroller
 * @Author: zhangdi
 * @Date: 2020年04月23日 10:31
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "findById/{id}")
    public User findById(@PathVariable("id") String userId) {
        return userService.findById(userId);
    }

    @RequestMapping(value = "insert")
    public int insertUser(@RequestBody User user) {
        return userService.insert(user);
    }

    @RequestMapping(value = "update")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "delete/{id}")
    public int deleteUser(@PathVariable("id") String userId) {
        return userService.deleteUser(userId);
    }
}
