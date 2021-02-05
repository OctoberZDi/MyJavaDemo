package com.example.springclouddemoconfigclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: INacosService
 * @Description: nacos service
 * @Author: zhangdi
 * @Date: 2020年04月09日 14:53
 **/
// 配置文件动态配置url
@FeignClient(url = "${feign.info.url}", name = "nacosservice")
public interface INacosService {

    /**
     * @return
     */
    @RequestMapping(value = "nacos/v1/ns/catalog/services?hasIpCount=false&withInstances=false&pageNo=1&pageSize=10&serviceNameParam=&groupNameParam=&namespaceId=")
    Object getService();

    /**
     * @return
     */
    @RequestMapping(value = "nacos/v1/ns/instance/list?serviceName={serviceName}")
    Object getInstance();
}
