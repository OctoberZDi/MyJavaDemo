package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: IDUtil
 * @Description: uuid工具类
 * @Author: zhangdi
 * @Date: 2020年01月20日 15:29
 **/
public class IDUtil {
    public static void main(String[] args) {
        System.out.println(IdUtil.randomUUID());
        System.out.println(IdUtil.simpleUUID());
        System.out.println(IdUtil.fastSimpleUUID());
        System.out.println(IdUtil.fastUUID());
        for (int i = 0; i < 10; i++) {
            System.out.println(StrUtil.toString(i) + ObjectId.next());
        }
        MD5 md5 = SecureUtil.md5();

    }
}
