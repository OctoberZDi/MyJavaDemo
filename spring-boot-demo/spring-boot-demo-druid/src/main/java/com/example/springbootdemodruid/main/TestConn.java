package com.example.springbootdemodruid.main;

import java.sql.*;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Test1
 * @Description: test1
 * @Author: zhangdi
 * @Date: 2020年04月23日 14:27
 **/
public class TestConn {
    public static void main(String[] args) throws SQLException {
        /*String url1 = "jdbc:mysql://localhost:3306/mydb?setUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "root";*/
        try {
            Class.forName("com.oscar.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:oscar://10.110.36.234:2020/OSRDB2020";
        Connection connection = DriverManager.getConnection(url, "sysdba", "szoscar55");
        // Statement statement = connection.createStatement();
        // ResultSet resultSet = statement.executeQuery("SELECT * FROM USER");
        System.out.println("最大连接数：" + connection.getMetaData().getMaxConnections());
        connection.close();
    }
}
