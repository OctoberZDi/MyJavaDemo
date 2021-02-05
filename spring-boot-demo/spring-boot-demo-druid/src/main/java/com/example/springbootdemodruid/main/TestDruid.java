package com.example.springbootdemodruid.main;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.util.JdbcConstants;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestDruid
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年11月24日 11:14
 **/
public class TestDruid {
    public static void main(String[] args) {
        System.out.println(SQLUtils.format("CREATE TABLE BUSINESS_TEST.CG_SYSTEM (ID varchar(32) not null,SYSTEM_NUMBER varchar(100),SYSTEM_NAME varchar(100))", JdbcConstants.ORACLE));
        String[] arr = new String[]{"1"};
    }
}