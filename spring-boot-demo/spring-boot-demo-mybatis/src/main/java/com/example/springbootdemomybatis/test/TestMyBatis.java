package com.example.springbootdemomybatis.test;

import com.example.springbootdemomybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestPlus
 * @Description: 用于查看源码
 * @Author: zhangdi
 * @Date: 2020年12月29日 15:04
 **/
public class TestMyBatis {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = (User) sqlSession.selectOne("selectById", "1342678073950191675");
        System.err.println(user);
        System.err.println("=============");
        String jdbcProp = "jdbc.properties";
        Properties resourceAsProperties = Resources.getResourceAsProperties(jdbcProp);
        System.err.println("read from Resources: " + resourceAsProperties.getProperty("url"));
        // ResourceBundle 不需要带着文件后缀.properties
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        System.err.println("read from ResourceBundle: " + bundle.getString("url"));
    }
}
