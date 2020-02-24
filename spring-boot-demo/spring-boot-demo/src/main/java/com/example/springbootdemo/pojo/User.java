package com.example.springbootdemo.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: User
 * @Description: 用户
 * @Author: zhangdi
 * @Date: 2020年02月22日 19:51
 **/
@Configuration
public class User implements IUserService {

    //静态变量
    private static String staticFiled = staticMethod();
    private String name;
    private String address;

    static {
        System.out.println("执行了静态代码块");
    }


    //赋值静态变量的静态方法
    public static String staticMethod() {
        System.out.println("执行了静态方法");
        return "给静态字段赋值了";
    }

    public String getName() {
        System.out.println("getName" + name);
        return name;
    }

    private void testPrivate() {
        System.out.println("test private method...");
    }

    public void setName(String name) {
        System.out.println("setName" + name);
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void getComment() {
        System.out.println("this is comment....");
    }
}
