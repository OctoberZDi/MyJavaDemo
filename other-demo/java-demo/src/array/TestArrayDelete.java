package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestArrayDelete
 * @Description: 测试删除arraylist方法
 * @Author: zhangdi
 * @Date: 2020年05月28日 11:23
 **/
public class TestArrayDelete {
    public static void main(String[] args) {

        List<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("1");
        arrayList1.add("2");
        arrayList1.add("3");
        arrayList1.add("3");
        arrayList1.add("5");

        Iterator<String> iterator = arrayList1.iterator();
        System.out.println("正序迭代");
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            /*if (next.equals("3")) {
                iterator.remove();
            }
            System.out.println(arrayList1);*/
        }
        System.out.println("倒序迭代");
        ListIterator<String> stringListIterator = arrayList1.listIterator();
        while (stringListIterator.hasNext()) {
            String next = stringListIterator.next();
            System.out.println(next);
        }
        while (stringListIterator.hasPrevious()) {
            System.out.println("previous:" + stringListIterator.previous());
            System.out.println("previousIndex:" + stringListIterator.previousIndex());
        }

        System.out.println("for 迭代");
        for (Iterator it = arrayList1.iterator(); it.hasNext(); ) {
            //迭代器的next方法返回值类型是Object，所以要记得类型转换。
            String next = (String) it.next();
            System.out.println(next);
        }
       /* for (String s : arrayList1) {
            if ("1".equals(s)) {
                arrayList1.remove(s);
            }
        }

        System.out.println("这种方式会报错");
        System.out.println("arraylist2为什么remove失败呢？因为它在循环第二次的时候，也remove成功了，但是第三次判断next的时候cursor的值为2导致不等于现在的size " +
                "1，所以执行了next方法，最重要的来了，之前remove的操作导致ArrayList的modCount值加1，然后Itr类中的expectedModCount保持不变，所以会抛出异常。");
        List<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("2");
        arrayList2.add("1");
        for (String s : arrayList2) {
            if ("1".equals(s)) {
                arrayList2.remove(s);
            }
        }*/
    }
}
