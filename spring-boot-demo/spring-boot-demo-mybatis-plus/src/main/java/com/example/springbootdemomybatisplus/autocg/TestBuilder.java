package com.example.springbootdemomybatisplus.autocg;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestBuilder
 * @Description: ddd
 * @Author: zhangdi
 * @Date: 2020年12月30日 15:22
 **/
public class TestBuilder {
    private TestBuilder() {
    }

    public static TestBuilder builder() {
        return new TestBuilder();
    }

    public TestBuilder test1() {
        System.out.println("test1");
        return this;
    }

    public TestBuilder test2() {
        System.out.println("test2");
        return this;
    }

    public TestBuilder test3() {
        System.out.println("test3");
        return this;
    }

    public static void main(String[] args) {
        TestBuilder.builder().test1().test2().test3();
    }
}
