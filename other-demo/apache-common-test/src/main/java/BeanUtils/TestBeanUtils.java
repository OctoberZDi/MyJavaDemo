package BeanUtils;

import common.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestMain
 * @Description: 测试BeanUtils
 * @Author: zhangdi
 * @Date: 2020年11月17日 16:07
 **/
public class TestBeanUtils {
    public static void main(String[] args) {
        System.out.println(MessageFormat.format("我是{0}，今年{1}岁", "张迪", 30));
        User user = new User("张迪", 29, "山东省临沂市");
        try {
            String name = BeanUtils.getProperty(user, "name");
            System.out.println(user);
            System.out.println(name);
            User user2 = (User) BeanUtils.cloneBean(user);

            System.out.println(user2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
