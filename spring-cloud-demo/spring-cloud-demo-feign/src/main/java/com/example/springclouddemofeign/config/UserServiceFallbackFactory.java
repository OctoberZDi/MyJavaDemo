package com.example.springclouddemofeign.config;

import com.alibaba.fastjson.JSONObject;
import com.example.springclouddemofeign.feignservice.UserService;
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
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public Object getStr2(String str) {
                return null;
            }

            @Override
            public String getStr(String str) {
                System.out.println("jwt service 调用失败。。。。执行服务降级");
                return null;
            }

            @Override
            public Object getObject(JSONObject object) {
                return null;
            }
        };
    }
}
