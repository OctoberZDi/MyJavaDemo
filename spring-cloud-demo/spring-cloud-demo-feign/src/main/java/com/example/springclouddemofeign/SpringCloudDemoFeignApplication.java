package com.example.springclouddemofeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhangdi03
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class SpringCloudDemoFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoFeignApplication.class, args);
    }

}
