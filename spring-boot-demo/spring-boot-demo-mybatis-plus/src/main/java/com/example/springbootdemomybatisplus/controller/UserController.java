package com.example.springbootdemomybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.springbootdemomybatisplus.entity.User;
import com.example.springbootdemomybatisplus.mapper.UserMappesr;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserController
 * @Description: userController
 * @Author: zhangdi
 * @Date: 2020年12月26日 11:19
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Resource
    UserMappesr userMappesr;

    @RequestMapping(value = "getAll")
    public Object getAllUser() {
        List<User> users = userMappesr.selectList(null);
        users.forEach(System.out::println);

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        return users;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public int insertUser(@RequestBody User user) {
        return userMappesr.insert(user);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public int updateUser(@RequestBody User user) {
        return userMappesr.updateById(user);
    }

    @RequestMapping(value = "testChain")
    public Object test() {
        // 链式调用1
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new QueryWrapper<User>().lambda();

        // 链式调用2
        LambdaQueryWrapper<User> userQueryChainWrapper = Wrappers.lambdaQuery();
        userQueryChainWrapper.like(User::getName, "张迪2").ge(User::getAge, 21);
        // 链式更新
        LambdaUpdateWrapper<User> userLambdaUpdateWrapper = Wrappers.lambdaUpdate();
        userLambdaUpdateWrapper.eq(User::getId, "1342678073950191676");
        User user = new User() {{
            this.setEmail("aaaaa@qq.com");
            this.setName("张迪2222222");
            this.setAge(29);
        }};
        this.userMappesr.update(user, userLambdaUpdateWrapper);

        return this.userMappesr.selectList(userQueryChainWrapper);
    }
}
