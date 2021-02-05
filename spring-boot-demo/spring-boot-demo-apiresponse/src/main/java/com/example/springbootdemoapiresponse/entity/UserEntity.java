package com.example.springbootdemoapiresponse.entity;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserEntity
 * @Description: user 实体
 * @Author: zhangdi
 * @Date: 2020年11月03日 09:29
 **/
public class UserEntity {
    private String name;
    private Integer age;

    public UserEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
