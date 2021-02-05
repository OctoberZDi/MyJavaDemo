package com.example.springbootdemojwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootDemoJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoJwtApplication.class, args);
    }

}
