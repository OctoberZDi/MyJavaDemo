package com.example.springbootdemoredis.controller;

import com.example.springbootdemoredis.entity.UserEntity;
import com.example.springbootdemoredis.util.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestRedisController
 * @Description: controller
 * @Author: zhangdi
 * @Date: 2020年05月12日 15:26
 **/
@RestController
@RequestMapping(value = "redis")
public class TestRedisController {

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "test")
    public String test() {
        String[] aa = new String[]{"111", "222", "名称", "cec测试事发时间到付件爱搜"};
        redisUtil.set("array1", aa);

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "张迪");
        map.put("code", "1111");
        redisUtil.set("map", map);
        return "v";
    }

    @RequestMapping(value = "test2")
    public String test2() throws IOException {
        UserEntity userEntity = new UserEntity("111222", UUID.randomUUID().toString(), "张迪", "30", new Date());
        new ObjectMapper().writeValue(new File(System.getProperty("user.dir") + "./test.json"), userEntity);

        System.out.println(userEntity);
        redisUtil.set(userEntity.getId(), new ObjectMapper().writeValueAsString(userEntity));
        return "set userentity";
    }

    @RequestMapping(value = "get2/{id}")
    public UserEntity get2(@PathVariable String id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserEntity userEntity = objectMapper.readValue(String.valueOf(redisUtil.get(id)), UserEntity.class);

        return userEntity;
    }
}
