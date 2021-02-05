package com.example.springbootdemomybatis.test;

import com.example.springbootdemomybatis.entity.User;
import com.example.springbootdemomybatis.mapper.UserMappesr;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestMain2
 * @Description: testmain2
 * @Author: zhangdi
 * @Date: 2021年01月08日 16:32
 **/
public class TestMain2 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        try (SqlSession sqlSession = build.openSession()) {
            // 方式1
            System.out.println("根据ID获取");
            UserMappesr mapper = sqlSession.getMapper(UserMappesr.class);
            User user = mapper.selectById("1342678073950191803");
            System.out.println(user);
            System.out.println("******");
            System.out.println("获取所有Users");
            List<User> users = mapper.selectAll();
            // 打印用户信息
            users.stream().forEach(System.out::println);
            sqlSession.commit();
            sqlSession.clearCache();
        } catch (Exception ex) {

        }
    }
}
