package com.example.springbootdemomybatis.sercice.impl;

import com.example.springbootdemomybatis.entity.User;
import com.example.springbootdemomybatis.mapper.UserMappesr;
import com.example.springbootdemomybatis.sercice.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserServiceImpl
 * @Description: userserviceimpl
 * @Author: zhangdi
 * @Date: 2021年02月05日 15:45
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    UserMappesr userMappesr;

    @Override
    public User selectById(String id) {
        return userMappesr.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return userMappesr.selectAll();
    }

    @Override
    public int insertUser(User user) {
        return userMappesr.insertUser(user);
    }

    @Override
    public int insertUsers(List<User> users) {
        return userMappesr.insertUsers(users);
    }

    @Override
    public int updateUserById(User user) {
        return userMappesr.updateUserById(user);
    }

    @Override
    public int deleteUserById(String id) {
        return userMappesr.deleteUserById(id);
    }
}
