package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.util.ZipUtil;

import java.io.File;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ZipUtilDemo
 * @Description: 压缩工具
 * @Author: zhangdi
 * @Date: 2020年01月20日 14:56
 **/
public class ZipUtilDemo {
    public static void main(String[] args) {
        File zipfile = ZipUtil.zip("D:/ofd/bbb.ofd");
        String absolutePath = zipfile.getAbsolutePath();
        System.out.println(absolutePath);

        File unzip = ZipUtil.unzip("d:/ofd/bbb.zip");
        System.out.println(unzip.getAbsolutePath());
    }
}
