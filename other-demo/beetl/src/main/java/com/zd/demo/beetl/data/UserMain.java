package com.zd.demo.beetl.data;

import com.zd.demo.beetl.UserServiceImpl;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserMain
 * @Description: 用户入口类
 * @Author: zhangdi
 * @Date: 2020年02月16日 13:28
 **/
public class UserMain {

    public static void main(String[] args) {
        Animal dog2 = new Dog();

        Dog dog = (Dog) new Animal();
        System.out.println(dog2.types);
        dog2.setName("wangwang");
        System.out.println("test service.....");
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.canEat());
        userService.getName();
        userService.run();

    }
}
