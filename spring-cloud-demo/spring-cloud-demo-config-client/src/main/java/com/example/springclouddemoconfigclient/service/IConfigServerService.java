package com.example.springclouddemoconfigclient.service;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: IConfigServer
 * @Description: feign获取config git配置信息
 * @Author: zhangdi
 * @Date: 2020年04月08日 15:10
 **/
@FeignClient(url = "http://localhost:1001/",name = "configEngine")
public interface IConfigServerService {

    @RequestMapping(value = "config-client/prod/master")
    Object getConfig();
}
