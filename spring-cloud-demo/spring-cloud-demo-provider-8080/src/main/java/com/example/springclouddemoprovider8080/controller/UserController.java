package com.example.springclouddemoprovider8080.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springclouddemoprovider8080.feignservice.UserRestClient;
import com.example.springclouddemoprovider8080.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserController
 * @Description:
 * @Author: zhangdi
 * @Date: 2020年05月16日 10:46
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 报错的请求
     *
     * @param str
     * @return
     */
    @RequestMapping(value = "getStr2/{str}", method = RequestMethod.POST)
    public Object getStr2(@PathVariable(value = "str") String str) {
        return str;
    }


    @RequestMapping(value = "getStr/{str}", method = RequestMethod.POST)
    public String getStr(@PathVariable(value = "str") String str) {
        return str;
    }

    @RequestMapping(value = "getById/{id}", method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "getUserFromService_hy")
    public Object getUserFromService(@PathVariable(value = "id") String id) {
        return userService.getUserByid(id);
    }

    public Object getUserFromService_hy(String id) {
        System.out.println(id + "*************");

        return "this is hystrix command method ...";
    }

    UserRestClient userRestClient;

    @Autowired
    public void setUserRestClient(UserRestClient userRestClient) {
        this.userRestClient = userRestClient;
    }

    @RequestMapping(value = "getByIdFromFeign/{id}", method = RequestMethod.POST)
    public Object getUserFromFeignService(@PathVariable("id") String id) {
        return userRestClient.getUserById(id);
    }

    @RequestMapping(value = "getObj", method = RequestMethod.POST)
    public Object getObject(@RequestBody JSONObject object) {
        return object;
    }
}
