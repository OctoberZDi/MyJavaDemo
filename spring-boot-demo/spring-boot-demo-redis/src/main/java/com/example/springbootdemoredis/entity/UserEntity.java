package com.example.springbootdemoredis.entity;

import java.util.Date;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserEntity
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年11月21日 10:15
 **/
public class UserEntity {
    private String id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;

    public UserEntity() {
    }

    public UserEntity(String id, String guid, String name, String age, Date createTime) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.age = age;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
