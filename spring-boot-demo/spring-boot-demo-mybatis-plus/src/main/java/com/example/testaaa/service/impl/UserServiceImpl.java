package com.example.testaaa.service.impl;

import com.example.testaaa.entity.User;
import com.example.testaaa.mapper.UserMapper;
import com.example.testaaa.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangdi
 * @since 2020-12-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
