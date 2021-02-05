package com.example.springbootdemojwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springbootdemojwt.annotation.UserLoginToken;
import com.example.springbootdemojwt.data.User;
import com.example.springbootdemojwt.service.impl.UserServiceImpl;
import com.example.springbootdemojwt.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: LoginController
 * @Description: 登录控制器
 * @Author: zhangdi
 * @Date: 2020年04月11日 17:07
 **/
@RestController
@RequestMapping(value = "login")
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    TokenUtil tokenUtil;

    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.getUserById(user.getUserid());
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = tokenUtil.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                System.out.println(token);
                return jsonObject;
            }
        }
    }

    @RequestMapping(value = "deToken")
    public DecodedJWT deToken(@RequestBody JSONObject userInfo) {
        DecodedJWT token = tokenUtil.deToken((String) userInfo.get("token"), (String) userInfo.get("password"));
        return token;
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }
}
