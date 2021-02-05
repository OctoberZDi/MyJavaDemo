package com.example.springbootdemo.controller;

import com.example.springbootdemo.feign.ISpringBootDemoDriudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestFeignController
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年04月23日 16:27
 **/
@RestController
@RequestMapping(value = "test")
public class TestFeignController {

    @Autowired
    ISpringBootDemoDriudService springBootDemoDriudService;

    @RequestMapping(value = "user/{id}")
    public Object testFeign(@PathVariable("id") String id) {
        return springBootDemoDriudService.findById(id);
    }
}
