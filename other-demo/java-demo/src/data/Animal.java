package data;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: BaseMan
 * @Description: 基类man
 * @Author: zhangdi
 * @Date: 2020年11月23日 14:04
 **/
public class Animal {
    boolean isSuperman;

    private void run(String animalName) {
        System.out.println(animalName + " is running...");
    }

    public void run2(String animalName) {
        System.out.println(animalName + " is running2...");
    }
}