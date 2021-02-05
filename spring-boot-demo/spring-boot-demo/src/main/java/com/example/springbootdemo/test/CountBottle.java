package com.example.springbootdemo.test;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: Count
 * @Description: cc
 * @Author: zhangdi
 * @Date: 2020年04月22日 16:17
 **/
public class CountBottle {
    public static void main(String[] args) {
        int drinkBottle = 20;
        int emptyBottle = 20;
        // 循环20个瓶子
        int i = 1;
        while (emptyBottle >= 4) {
            System.out.println("========================");
            System.out.println("第" + i + "次喝");
            int canDrink = emptyBottle / 4;
            drinkBottle += canDrink;
            System.out.println("喝了：" + drinkBottle);

            int addEmptyBottle = emptyBottle / 4;
            int replacedBottle = (emptyBottle / 4) * 4;
            // 减去换掉的，然后加上又喝的几个空瓶子
            emptyBottle = emptyBottle - replacedBottle + addEmptyBottle;
            System.out.println("空瓶：" + emptyBottle);

            i++;
        }
        System.out.println("总共喝了：" + drinkBottle + "瓶");
    }
}
