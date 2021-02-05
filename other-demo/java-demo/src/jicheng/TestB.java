package jicheng;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestB
 * @Description: d
 * @Author: zhangdi
 * @Date: 2020年08月19日 13:42
 **/
public class TestB {
    public String testA() {
        System.out.println("TestB.method1");
        System.out.println(this);
        b();
        return "TestB.testA";
    }

    protected void b() {
        System.out.println("TestB.b");
    }
}
