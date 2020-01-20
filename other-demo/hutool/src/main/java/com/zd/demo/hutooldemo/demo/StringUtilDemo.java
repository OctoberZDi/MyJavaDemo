package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @ProjectName: MyGitHub-OctoberZDi-springboot-learning
 * @ClassName: StrUtilDemo
 * @Description: 测试strUtil的demo
 * @Author: zhangdi
 * @Date: 2020年01月20日 13:46
 **/
@Slf4j
public class StringUtilDemo {

    public static void main(String[] args) {
        System.out.println("StrUtil.....Start");
        String empty = StrUtil.emptyIfNull(null);
        String defaultStr = StrUtil.nullToDefault(null, "defaultStr");

        System.out.println("StrUtil.....End");
    }
}
