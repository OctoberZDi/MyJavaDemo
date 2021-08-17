package com.example.springbootdemomybatis.mapper;

import com.example.springbootdemomybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserMappesr
 * @Description: userMapper
 * @Author: zhangdi
 * @Date: 2020年12月26日 11:12
 **/
@Mapper
public interface UserMappesr {
    /*@Select("select * from user where id=#{id}")*/
    User selectById(String id);

    // 看mybatis-config.xml的mappers节点配置，要么使用注解（类中的@select)要么使用mapper.xml中的，不能同时使用
    /*@Select("select * from user")*/
    List<User> selectAll();

    // 看mybatis-config.xml的mappers节点配置，要么使用注解（类中的@select)要么使用mapper.xml中的，不能同时使用
    /*@Select("select * from user")*/
    Cursor<User> selectAllByLimit(@Param("limit") int limit, @Param("offset") int offset);

    int insertUser(User user);

    int insertUsers(@Param("users") List<User> users);

    int updateUserById(@Param("user") User user);

    int deleteUserById(@Param("id") String id);
}
