package com.example.springbootdemocorstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootDemoCorsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoCorsTestApplication.class, args);
    }

}
