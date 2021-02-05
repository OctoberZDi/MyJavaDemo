package com.example.springclouddemoprovider8080.config;

import com.example.springclouddemoprovider8080.feignservice.UserRestClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserServiceFallbackFactory
 * @Description:
 * @Author: zhangdi
 * @Date: 2020年05月16日 16:28
 **/
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserRestClient> {
    @Override
    public UserRestClient create(Throwable throwable) {
        return new UserRestClient() {
            @Override
            public Object getUserById(String id) {
                System.out.println("jwt service 调用失败。。。。执行服务降级");
                return null;
            }
        };
    }
}
