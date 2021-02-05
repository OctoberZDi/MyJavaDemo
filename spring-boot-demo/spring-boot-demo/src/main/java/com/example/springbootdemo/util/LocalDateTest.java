package com.example.springbootdemo.util;

import com.example.springbootdemo.pojo.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: LocalDateTest
 * @Description: 测试LocalDate
 * @Author: zhangdi
 * @Date: 2020年04月03日 17:44
 **/
public class LocalDateTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("");
        user.setAddress("");

        LocalDate now = LocalDate.now();
        System.out.println(now.toString());

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1.toString());
    }
}
