package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.lang.Validator;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: ValidatorDemo
 * @Description: 判断验证工具类
 * @Author: zhangdi
 * @Date: 2020年01月20日 15:15
 **/
public class ValidatorDemo {

    public static void main(String[] args) {
        boolean birthday = Validator.isBirthday("19922362");
        System.out.println(birthday);
        TemplateUtil.createEngine(new TemplateConfig());
    }
}
