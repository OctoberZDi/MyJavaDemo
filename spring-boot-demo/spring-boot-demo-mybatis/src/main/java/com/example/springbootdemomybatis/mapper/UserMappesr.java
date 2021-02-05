package com.example.springbootdemomybatis.mapper;

import com.example.springbootdemomybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserMappesr
 * @Description: userMapper
 * @Author: zhangdi
 * @Date: 2020年12月26日 11:12
 **/
@Repository
public interface UserMappesr {
    /*@Select("select * from user where id=#{id}")*/
    User selectById(@Param("id") String id);

    // 看mybatis-config.xml的mappers节点配置，要么使用注解（类中的@select)要么使用mapper.xml中的，不能同时使用
    /*@Select("select * from user")*/
    List<User> selectAll();

    int insertUser(User user);

    int insertUsers(@Param("users") List<User> users);

    int updateUserById(@Param("user") User user);

    int deleteUserById(@Param("id") String id);
}
