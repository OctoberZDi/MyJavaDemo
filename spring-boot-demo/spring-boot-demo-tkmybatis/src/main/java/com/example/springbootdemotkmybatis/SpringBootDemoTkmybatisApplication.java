package com.example.springbootdemotkmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zhangdi03
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.example.springbootdemotkmybatis.mapper.**"})
public class SpringBootDemoTkmybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoTkmybatisApplication.class, args);
    }

}
