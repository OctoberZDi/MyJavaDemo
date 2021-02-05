package com.example.springbootdemodruid.service;

import com.example.springbootdemodruid.data.User;
import com.example.springbootdemodruid.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserService
 * @Description: userservice
 * @Author: zhangdi
 * @Date: 2020年04月23日 10:29
 **/
@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public User findById(String userId) {
        return userMapper.findById(userId);
    }

    public int insert(User user) {
        LocalDate birth = user.getBirth();
        
        return userMapper.insert(user);
    }

    public int updateUser(User user) {
        return userMapper.update(user);
    }

    public int deleteUser(String userId) {
        return userMapper.delete(userId);
    }
}
