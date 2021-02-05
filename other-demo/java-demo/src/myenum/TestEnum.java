package myenum;

import java.util.Arrays;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestEnum
 * @Description: 测试枚举
 * @Author: zhangdi
 * @Date: 2020年08月03日 13:56
 **/
public enum TestEnum {
    /*
     *周枚举
     */
    MONDAY("1", "星期一"), TUESDAY("2", "星期二"), WEDNESDAY("3", "星期三"), THURSDAY("4", "星期四"), FRIDAY("5", "星期五"), SATURDAY(
            "6", "星期六"),
    SUNDAY("7", "星期日");

    TestEnum(String dayOfWeek, String week) {
    }

    public static void main(String[] args) {
        Arrays.stream(TestEnum.values()).forEach(System.out::println);
    }

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }
}
