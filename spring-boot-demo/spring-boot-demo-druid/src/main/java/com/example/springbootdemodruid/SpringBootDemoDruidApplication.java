package com.example.springbootdemodruid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootDemoDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDruidApplication.class, args);
    }

}
