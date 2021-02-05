package proxy.dongtai;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: DongtaiProxyTest
 * @Description:
 * @Author: zhangdi
 * @Date: 2020年05月26日 14:13
 **/
public class DongtaiProxyTest {

    public static void main(String[] args) {
        System.out.println("动态代理实现方式1：java.lang.reflect Proxy");
        UserDao userDao = new UserDao();
        System.out.println(userDao.getClass().getClassLoader());
        System.out.println(Arrays.toString(userDao.getClass().getInterfaces()));

        IUserDao target = new UserDao();
        //输出目标对象信息
        System.out.println(target.getClass());
        //输出代理对象信息
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理方法
        proxy.say(" hello!");
        System.out.println("动态代理实现方式2：cglib");

        IUserDao userDao1 = (IUserDao) new ProxyFactory2(target).getProxyInstance();
        userDao1.say(" cglib");

        System.out.println("测试map的getOrDefault");
        Map<String, Object> map = new HashMap(10) {
            {
                put("name", null);
            }
        };

        System.out.println(map.getOrDefault("name", "222"));
        System.out.println(map.getOrDefault("name2", "2333"));
    }
}
