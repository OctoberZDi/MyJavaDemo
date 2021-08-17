package stream.usage;

import stream.Person;
import stream.PersonBuilder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: UseDemo1
 * @Description: 使用demo1
 * @Author: zhangdi
 * @Date: 2021年04月23日 10:32
 **/
public class UseDemo1 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(PersonBuilder.aPerson().withName("Tom").withAge(21).withSalary(8900).withArea("济南").withSex("男").build());
        personList.add(PersonBuilder.aPerson().withName("Tom1").withAge(22).withSalary(7000).withArea("济南1").withSex("女").build());
        personList.add(PersonBuilder.aPerson().withName("Tom2").withAge(23).withSalary(7800).withArea("济南2").withSex("女").build());
        personList.add(PersonBuilder.aPerson().withName("Tom3").withAge(24).withSalary(8200).withArea("济南3").withSex("男").build());
        personList.add(PersonBuilder.aPerson().withName("Tom4").withAge(25).withSalary(9500).withArea("济南4").withSex("女").build());
        personList.add(PersonBuilder.aPerson().withName("Tom5").withAge(26).withSalary(7900).withArea("济南5").withSex("男").build());

        personList.stream().filter(x -> "女".equals(x.getSex())).forEach(System.out::println);
        Optional<Person> first = personList.stream().filter(x -> "女".equals(x.getSex())).findFirst();
        if (first.isPresent()) {
            Person person = first.get();
            System.out.println(person);
        } else {
            System.out.println("不存在");
        }

        System.out.println("=====");
        List<Person> collect = personList.stream().filter(x -> x.getSalary() > 8000).collect(Collectors.toList());
        System.out.println(collect);
        List<String> collect1 = personList.stream().filter(x -> x.getSalary() > 8000).map(x->x.getName().toUpperCase(Locale.ROOT)).collect(Collectors.toList());
        System.out.println(collect1);

        // 最大工资
        Optional<Person> max = personList.stream().max(Comparator.comparing(Person::getSalary));
        System.out.println(max.get());

        System.out.println(personList.stream().filter(x -> x.getSalary() > 8000).count());
    }
}
