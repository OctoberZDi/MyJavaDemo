package com.example.springbootdemojwt.service.impl;

import com.example.springbootdemojwt.dao.UserMapper;
import com.example.springbootdemojwt.data.User;
import com.example.springbootdemojwt.data.UserExample;
import com.example.springbootdemojwt.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserService
 * @Description: userserviceImpl
 * @Author: zhangdi
 * @Date: 2020年04月11日 17:00
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        return userMapper.selectOneByExample(userExample);
    }
}
