package com.example.springbootdemofile;

import com.example.springbootdemofile.property.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileProperties.class
})
public class SpringBootDemoFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoFileApplication.class, args);
    }

}
