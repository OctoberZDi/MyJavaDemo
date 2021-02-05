package com.example.springbootdemotkmybatis.controller;

import com.example.springbootdemotkmybatis.po.CgDataSource;
import com.example.springbootdemotkmybatis.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: HelloController
 * @Description: cc
 * @Author: zhangdi
 * @Date: 2020年08月26日 16:34
 **/
@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "say", method = RequestMethod.GET)
    public List<CgDataSource> getList() {
        List<CgDataSource> cgDataSources = helloService.sayHello();
        System.out.println("count=" + cgDataSources.size());
        return cgDataSources;
    }
}
