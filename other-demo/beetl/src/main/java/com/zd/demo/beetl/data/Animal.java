package com.zd.demo.beetl.data;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Animal
 * @Description: 父类的定义
 * @Author: zhangdi
 * @Date: 2020年02月16日 14:32
 **/
public class Animal {
    private String name;
    public final String types = "this is animal's types...";
    private final String comment = "this is animal's comment,...";

    public String getAnimalComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal() {
        System.out.println("animal constructor...");
    }

    public void animalName() {
        System.out.println(this.name);
    }

    private void animalSay() {
        System.out.println("animals can say...");
    }

    protected void animalRun() {
        System.out.println("animals can run...");
    }
}
