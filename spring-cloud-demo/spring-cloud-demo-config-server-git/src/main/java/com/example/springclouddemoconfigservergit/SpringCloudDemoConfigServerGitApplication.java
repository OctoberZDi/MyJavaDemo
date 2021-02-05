package com.example.springclouddemoconfigservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // 开启spring cloud config服务端功能
public class SpringCloudDemoConfigServerGitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoConfigServerGitApplication.class, args);
    }

}
