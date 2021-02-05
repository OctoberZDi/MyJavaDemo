package com.example.springbootdemojwt.dao;

import com.example.springbootdemojwt.data.User;
import com.example.springbootdemojwt.data.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    User selectOneByExample(UserExample example);

    User selectOneByExampleSelective(@Param("example") UserExample example, @Param("selective") User.Column... selective);

    List<User> selectByExampleSelective(@Param("example") UserExample example, @Param("selective") User.Column... selective);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}