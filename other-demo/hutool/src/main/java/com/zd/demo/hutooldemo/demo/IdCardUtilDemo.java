package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: IdCardUtilDemo
 * @Description: 身份证工具类
 * @Author: zhangdi
 * @Date: 2020年01月20日 15:03
 **/
public class IdCardUtilDemo {
    public static void main(String[] args) {
        String id1 = "371325199110022331";
        String id2 = "370481199002145348";
        boolean validCard1 = IdcardUtil.isValidCard(id1);
        boolean validCard2 = IdcardUtil.isValidCard(id2);
        System.out.println(StrUtil.toString(validCard1) + id1.length());
        System.out.println("获取生日:" + IdcardUtil.getBirthByIdCard(id1));
        System.out.println("获取性别:" + IdcardUtil.getGenderByIdCard(id1));
        System.out.println("获取生日年:" + IdcardUtil.getYearByIdCard(id1));
        System.out.println("获取生日月:" + IdcardUtil.getMonthByIdCard(id1));
        System.out.println("获取生日天:" + IdcardUtil.getDayByIdCard(id1));
        System.out.println("获取省份:" + IdcardUtil.getProvinceByIdCard(id1));

        System.out.println(StrUtil.toString(validCard2) + id2.length());
        System.out.println("获取生日:" + IdcardUtil.getBirthByIdCard(id2));
        System.out.println("获取性别:" + IdcardUtil.getGenderByIdCard(id2));
        System.out.println("获取生日年:" + IdcardUtil.getYearByIdCard(id2));
        System.out.println("获取生日月:" + IdcardUtil.getMonthByIdCard(id2));
        System.out.println("获取生日天:" + IdcardUtil.getDayByIdCard(id2));
        System.out.println("获取省份:" + IdcardUtil.getProvinceByIdCard(id2));
    }
}
