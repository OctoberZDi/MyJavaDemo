package com.example.springbootdemomybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ExampleTypeHandler
 * @Description: exampleHandler
 * @Author: zhangdi
 * @Date: 2020年12月28日 14:12
 **/
public class ExampleTypeHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        System.out.println("设置参数->自定义typeHandler生效了");

        preparedStatement.setString(i,"ddd");
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("根据columnName获取结果->自定义typeHandler生效了");
        return resultSet.getString(s);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("根据columnIndex获取结果->自定义typeHandler生效了");
        return resultSet.getString(i);
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("根据columnName获取结果->自定义typeHandler生效了");
        return callableStatement.getString(i);
    }
}
