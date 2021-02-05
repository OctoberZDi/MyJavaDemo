package com.example.springbootdemo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestMapInit
 * @Description: 测试hashmap初始化
 * @Author: zhangdi
 * @Date: 2020年05月08日 13:55
 **/
public class TestMapInit {

    private final static HashMap<String, String> nameCodeMap = new HashMap<String, String>() {
        {
            put("tom", "111");
            put("jerry", "222");
        }
    };

    public static void main(String[] args) {
        Set<String> strings = nameCodeMap.keySet();
        final Set<Map.Entry<String, String>> entries = nameCodeMap.entrySet();
        for (String s : nameCodeMap.keySet()) {
            System.out.println(s);
            System.out.println(nameCodeMap.get(s));
        }
    }
}
