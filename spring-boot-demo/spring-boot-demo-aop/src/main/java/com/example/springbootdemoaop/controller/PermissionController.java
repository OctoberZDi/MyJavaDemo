package com.example.springbootdemoaop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemoaop.annotation.PermissionAnnotation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: LogController
 * @Description: log controller
 * @Author: zhangdi
 * @Date: 2020年04月08日 17:05
 **/
@RequestMapping(value = "per")
@RestController
public class PermissionController {
    /**
     * 添加这个注解PermissionsAnnotation
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @PermissionAnnotation
    public JSONObject getGroupList(@RequestBody JSONObject request) {
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }
}
