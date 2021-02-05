package com.example.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: SentinelController
 * @Description: 前哨控LightEdit制器
 * @Author: zhangdi
 * @Date: 2020年04月30日 10:09
 **/
@RestController
public class SentinelController {

    //批注用于标识资源是否受速率限制或降级。在上面的示例中，注释的'hello'属性引用资源名称。
    @SentinelResource()
    @RequestMapping(value = "hello")
    public String getHello() {
        return "hello sentinel";
    }
}
