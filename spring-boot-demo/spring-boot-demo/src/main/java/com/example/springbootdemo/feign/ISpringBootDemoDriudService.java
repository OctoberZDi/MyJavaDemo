package com.example.springbootdemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ISpringBootDemoDriudService
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年04月23日 16:19
 **/
@FeignClient(value = "spring-boot-demo-druid")
public interface ISpringBootDemoDriudService {

    @RequestMapping(value = "user/findById/{id}")
    Object findById(@PathVariable("id") String id);
}
