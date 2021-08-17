package com.example.springbootdemomybatis.sercice;

import com.example.springbootdemomybatis.entity.User;

import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: IUserService
 * @Description: IUserService
 * @Author: zhangdi
 * @Date: 2021年02月05日 15:30
 **/
public interface IUserService {
    User selectById(String id);

    List<User> selectAll();

    int insertUser(User user);

    int insertUsers(List<User> users);

    int updateUserById(User user);

    int deleteUserById(String id);
}
