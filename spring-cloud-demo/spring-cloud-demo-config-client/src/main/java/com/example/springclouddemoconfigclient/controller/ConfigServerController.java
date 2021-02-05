package com.example.springclouddemoconfigclient.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springclouddemoconfigclient.service.IConfigServerService;
import com.example.springclouddemoconfigclient.service.INacosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ConfigServerController
 * @Description: controller
 * @Author: zhangdi
 * @Date: 2020年04月08日 15:16
 **/
@RestController
@RequestMapping(value = "config")
public class ConfigServerController {

    @Autowired
    IConfigServerService configServer;

    @Autowired
    INacosService nacosService;

    @RequestMapping(value = "get")
    public Object getConfig() {
        Map object = (Map) configServer.getConfig();
        System.out.println(object);
        return object;
    }

    @RequestMapping(value = "getService")
    public Object getService() {
        Object service = nacosService.getService();
        System.out.println(service);
        return service;
    }

    @RequestMapping(value = "getInts")
    public Object getInts() {
        Object service = nacosService.getInstance();
        System.out.println(service);
        return service;
    }
}
