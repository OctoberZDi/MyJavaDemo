package com.example.springbootdemojwt.service;

import com.example.springbootdemojwt.data.User;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: IUserService
 * @Description: userservice
 * @Author: zhangdi
 * @Date: 2020年04月11日 16:58
 **/
public interface IUserService {

    User getUserById(String userId);
}
