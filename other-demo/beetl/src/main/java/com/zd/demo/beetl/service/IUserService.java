package com.zd.demo.beetl.service;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: IUserService
 * @Description:
 * @Author: zhangdi
 * @Date: 2020年02月16日 20:20
 **/
public interface IUserService {
    void getName();

    static void eat() {
        System.out.println("eat sth..." + IUserService.class.toString());
    }

    default void run() {
        System.out.println("run quickly..." + IUserService.class.toString());
    }
}
