package com.zd.demo.hutooldemo.demo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.DynaBean;
import com.zd.demo.hutooldemo.data.User;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: BenUtilDemo
 * @Description: BeanUtilDemo
 * @Author: zhangdi
 * @Date: 2020年02月15日 15:26
 **/
public class BeanUtilDemo {

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    public static Long convertTimeToLong(String time) {
        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse("2018-05-29 13:52:50", ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(Long time) {
        Assert.notNull(time, "time is null");
        System.out.println(time);
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    public static void main(String[] args) {
        String str = convertTimeToString(System.currentTimeMillis());
        System.out.println("*******"+str);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        LocalDateTime localDateTime = timestamp.toLocalDateTime().plusHours(8);
        System.out.println(localDateTime);

        Long millisecond = Instant.now().toEpochMilli();  // 精确到毫秒
        Long second = Instant.now().getEpochSecond();// 精确到秒

        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss"));
        System.out.println(format);
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
