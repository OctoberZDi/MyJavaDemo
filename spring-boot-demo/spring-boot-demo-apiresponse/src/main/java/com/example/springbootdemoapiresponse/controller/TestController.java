package com.example.springbootdemoapiresponse.controller;

import com.example.springbootdemoapiresponse.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestController
 * @Description: 测试控制器
 * @Author: zhangdi
 * @Date: 2020年11月02日 18:14
 **/
@RestController
@RequestMapping(value = "test")
public class TestController {

    @RequestMapping(value = "testSuccess", method = RequestMethod.GET)
    public Object testSuccess() {
        return "success";
    }

    @RequestMapping(value = "testFailure", method = RequestMethod.GET)
    public Object testFailure() {
        String[] arrs = new String[]{"11", "22", "33"};
        System.out.println(arrs[2]);
        return arrs[2];
    }

    @RequestMapping(value = "testConverter", method = RequestMethod.GET)
    public List<UserEntity> testConverter() {
        List<UserEntity> list = new ArrayList<UserEntity>();
        UserEntity u1 = new UserEntity("zhangdi", null);
        list.add(u1);
        return list;
    }
}
