package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;

/**
 * @ProjectName: MyGitHub-OctoberZDi-springboot-learning
 * @ClassName: ConvertUtilDemo
 * @Description: 类型转换工具类-Convert
 * @Author: zhangdi
 * @Date: 2020年01月20日 14:07
 **/
public class ConvertUtilDemo {

    public static void main(String[] args) {
        System.out.println("半角全角转换");
        String toSBC = Convert.toSBC("12345abcde");
        System.out.println(toSBC);
        String toDBC = Convert.toDBC("１２３４５６７８９　０");
        System.out.println(toDBC);

        boolean basicType = ObjectUtil.isBasicType("dd");
        System.out.println(basicType);

    }
}
