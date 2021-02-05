package com.example.springbootdemomybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.example.springbootdemomybatisplus.**.mapper.**"})
public class SpringBootDemoMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoMybatisPlusApplication.class, args);
    }

}
