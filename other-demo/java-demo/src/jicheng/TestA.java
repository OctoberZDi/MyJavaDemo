package jicheng;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestA
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年08月19日 13:43
 **/
public class TestA extends TestB {
    public void a() {
        super.testA();
    }

    protected void b() {
        System.out.println("TestA.b");
    }
}
