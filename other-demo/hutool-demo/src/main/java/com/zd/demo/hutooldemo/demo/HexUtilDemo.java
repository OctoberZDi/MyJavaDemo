package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;

/**
 * @ProjectName: MyGitHub-OctoberZDi-springboot-learning
 * @ClassName: HexUtilDemo
 * @Description: 16进制工具-HexUtil
 * @Author: zhangdi
 * @Date: 2020年01月20日 13:56
 **/
public class HexUtilDemo {
    public static void main(String[] args) {
        String testStr = "我是一个字符串";
        String encodeHexStr = HexUtil.encodeHexStr(testStr, CharsetUtil.CHARSET_UTF_8);
        System.out.println(encodeHexStr);
        String decodeHexStr = HexUtil.decodeHexStr(encodeHexStr);
        System.out.println(decodeHexStr);

    }
}
