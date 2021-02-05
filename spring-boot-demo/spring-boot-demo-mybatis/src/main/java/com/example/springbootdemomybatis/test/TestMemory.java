package com.example.springbootdemomybatis.test;

import com.example.springbootdemomybatis.entity.User;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestMemory
 * @Description: TestMemory
 * @Author: zhangdi
 * @Date: 2021年01月08日 16:55
 **/
public class TestMemory {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("张迪");
        user1.setAge(30);
        System.out.println(user1);

        User user2 = new User();
        user2 = user1;
        System.out.println(user2);
        user2.setName("小满");
        user2.setAge(2);
        System.out.println(user2);
        System.out.println(System.getProperty("user.dir"));
    }
}
