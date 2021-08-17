package com.example.springbootdemomybatis.test;

import com.example.springbootdemomybatis.entity.User;
import com.example.springbootdemomybatis.mapper.UserMappesr;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

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
        String jbdcResource = "jdbc.properties";
        // Resources 读取properties文件
        Properties resourceAsProperties = Resources.getResourceAsProperties(jbdcResource);
        System.out.println("Resources 读取properties文件" + resourceAsProperties);
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

/*
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/mydb?setUnicode=true&characterEncoding=utf8&useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true");
        properties.setProperty("username", "root");
        properties.setProperty("password", "root");
        SqlSessionFactory build1 = new SqlSessionFactoryBuilder().build(resourceAsStream, "development2", properties);
*/

        // openSession 不带参数的，不自动提交,需要手动提交
        try (SqlSession sqlSession = build.openSession(true)) {
            User user = new User() {
                {
                    this.setName("张迪");
                    this.setAge(21);
                    this.setEmail("912688695@qq.com");
                    this.setCreate_time(new Timestamp(System.currentTimeMillis()));
                    this.setUpdate_time(new Timestamp(System.currentTimeMillis()));
                }
            };
            System.out.println(user);
            int insertUser = sqlSession.insert("insertUser", user);
            System.out.println("插入：" + insertUser + "条");
            // 方式1
            System.out.println("根据ID获取");
            UserMappesr mapper = sqlSession.getMapper(UserMappesr.class);
            User user1 = mapper.selectById("1342678073950191810");
            System.out.println(user1);
            System.out.println("******");
            System.out.println("获取所有Users");
            List<User> users = mapper.selectAll();
            // 打印用户信息
            users.stream().forEach(System.out::println);

            // 流式查询
            System.out.println("流式查询");
            Cursor<User> userCursor = mapper.selectAllByLimit(6, 2);
            userCursor.forEach(item -> {
                System.out.println(item + "&&&");
            });
            sqlSession.clearCache();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
