package com.example.springclouddemoconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudDemoConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoConfigClientApplication.class, args);
    }

}
