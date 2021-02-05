package java8;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: InstanceOfTest
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年09月03日 16:44
 **/
public class InstanceOfTest {
    public static void main(String[] args) {
        int a = 100;
        // instanceof obj 必须未引用类型，不能为基本类型，如下代码编译不通过
        // boolean b = a instanceof int;
        // obj为null,则返回false
        Object b = null;
        System.out.println("null instanceof = " + (b instanceof Object));
        System.out.println("null instanceof = " + (null instanceof Object));

    }
}
