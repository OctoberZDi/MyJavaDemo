package com.zd.demo.beetl.loader;

import java.io.IOException;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestMain
 * @Description:
 * @Author: zhangdi
 * @Date: 2020年02月15日 16:04
 **/
public class TestTempMain {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world");
        System.out.println(System.getProperty("user.dir"));
        TemplateLoader templateLoader = new TemplateLoader();
        templateLoader.generate();
    }
}
