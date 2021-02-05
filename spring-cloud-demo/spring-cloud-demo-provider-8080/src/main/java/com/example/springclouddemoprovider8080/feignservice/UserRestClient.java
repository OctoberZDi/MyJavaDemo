package com.example.springclouddemoprovider8080.feignservice;

import com.example.springclouddemoprovider8080.config.UserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserRestClient
 * @Description:
 * @Author: zhangdi
 * @Date: 2020年05月16日 16:23
 **/
@FeignClient(value = "jwt-service", fallbackFactory = UserServiceFallbackFactory.class)
public interface UserRestClient {
    /**
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/getById/{id}")
    Object getUserById(@PathVariable(value = "id") String id);
}
