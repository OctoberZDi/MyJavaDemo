package com.example.springbootdemomybatis.controller;

import com.example.springbootdemomybatis.entity.User;
import com.example.springbootdemomybatis.sercice.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UserController
 * @Description: controller.UserController
 * @Author: zhangdi
 * @Date: 2021年02月05日 15:41
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {

    private IUserService userService;

    @Value("#{'${test.list}'.empty ? null :'${test.list}'.split(',')}")
    private List<String> testList;

    /**
     * : 冒号，key不存在时候使用的默认值，使用默认值值数组的length=0
     */
    @Value("${test.list1:}")
    private List<String> testList1;

    @Value("#{${test.map1}}")
    private Map<String, String> testMap;

    @Value("#{${test.set}}")
    private Set<Integer> testSet;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String selectById() {
        System.out.println(testList);
        System.out.println("======");
        System.out.println(testList1);
        System.out.println("======");
        System.out.println(testMap);
        System.out.println("======");
        System.out.println(testSet);
        return "hello mybatis...";
    }

    @RequestMapping(value = "selectById", method = RequestMethod.GET)
    public User selectById(@RequestParam("id") String id) {
        return userService.selectById(id);
    }

    @RequestMapping(value = "selectAll", method = RequestMethod.GET)
    public List<User> selectAll() {
        return userService.selectAll();
    }

    @RequestMapping(value = "insertUser", method = RequestMethod.POST)
    public int insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @RequestMapping(value = "insertUsers", method = RequestMethod.POST)
    public int insertUsers(@RequestBody List<User> users) {
        return userService.insertUsers(users);
    }

    @RequestMapping(value = "updateUserById", method = RequestMethod.GET)
    public int updateUserById(@RequestBody User user) {
        return userService.updateUserById(user);
    }

    @RequestMapping(value = "deleteUserById", method = RequestMethod.POST)
    public int deleteUserById(@RequestParam("id") String id) {
        return userService.deleteUserById(id);
    }
}
