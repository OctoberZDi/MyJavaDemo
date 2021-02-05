package com.example.springbootdemojwt.data;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Student
 * @Description: 学生测试类，测试lombok链式调用
 * @Author: zhangdi
 * @Date: 2020年04月15日 10:28
 **/
@Data
//@Accessors(chain = true)
@Builder
public class Student {
    private String id;
    private String name;

    public static void main(String[] args) {
        // Student student = new Student().setId("00001").setName("zhangdi");
        Student student = Student.builder().name("zhangdi").id("222").build();
        System.out.println(student);
    }
}