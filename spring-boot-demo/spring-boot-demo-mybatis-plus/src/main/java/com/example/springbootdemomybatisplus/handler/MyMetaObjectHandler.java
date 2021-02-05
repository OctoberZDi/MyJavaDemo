package com.example.springbootdemomybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: MyMetaObjectHandler
 * @Description: 处理器，特殊处理时间固定输入
 * @Author: zhangdi
 * @Date: 2020年12月26日 15:18
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("****insertFill****");
        System.out.println(metaObject);
        this.setFieldValByName("createTime", new Timestamp(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("updateTime", new Timestamp(System.currentTimeMillis()), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("****updateFill****");
        System.out.println(metaObject);
        this.setFieldValByName("updateTime", new Timestamp(System.currentTimeMillis()), metaObject);
    }
}
