package com.example.springbootdemofileuploadclient.config;

import feign.Logger;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: MultipartSupportConfig
 * @Description: config.MultipartSupportConfig
 * @Author: zhangdi
 * @Date: 2021年01月26日 17:46
 **/
@Configuration
public class MultipartSupportConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }
    @Bean
    public Logger.Level feignLoggerLevel() {
        System.out.println("*********************");
        return Logger.Level.FULL;
    }
}
