package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.util.EscapeUtil;

/**
 * @ProjectName: MyGitHub-OctoberZDi-springboot-learning
 * @ClassName: EscapeUtilDemo
 * @Description: escape工具
 * @Author: zhangdi
 * @Date: 2020年01月20日 14:01
 **/
public class EscapeUtilDemo {

    public static void main(String[] args) {
        String escape = EscapeUtil.escape("!*!(@#(FIH)@!*)!)@UI)J)JF)JF");
        System.out.println(escape);
        String unescape = EscapeUtil.unescape("!*!(@#(FIH)@!*)!)@UI)J)JF)JF");
        System.out.println(unescape);
    }
}
