package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.lang.Dict;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: DictUtil
 * @Description: 测试Dict
 * @Author: zhangdi
 * @Date: 2020年01月20日 15:12
 **/
public class DictUtil {
    public static void main(String[] args) {
        Dict set = Dict.create().set("name", "zhangdi").set("age", "21").set("from", "山东");
    }
}
