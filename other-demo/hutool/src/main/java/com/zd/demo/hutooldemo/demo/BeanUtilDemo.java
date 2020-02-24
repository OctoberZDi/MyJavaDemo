package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.DynaBean;
import com.zd.demo.hutooldemo.data.User;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: BenUtilDemo
 * @Description: BeanUtilDemo
 * @Author: zhangdi
 * @Date: 2020年02月15日 15:26
 **/
public class BeanUtilDemo {
    public static void main(String[] args) {
        System.out.println("BeantoMap");
        User user1 = new User();
        user1.setName("zhangdi");
        user1.setPassword("11111");
        user1.setAge(24);
        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(user1);
        System.out.println(stringObjectMap);
        System.out.println(user1.toString());

        System.out.println("test dynabean");
        DynaBean dynaBean = DynaBean.create(user1);
        dynaBean.set("name", "zhang33eeedi");
        dynaBean.set("age", 12);
        dynaBean.set("password", "11222211");
        System.out.println(dynaBean);

        Class<? extends User> aClass = user1.getClass();
        final Annotation[] annotations = aClass.getAnnotations();

    }
}
