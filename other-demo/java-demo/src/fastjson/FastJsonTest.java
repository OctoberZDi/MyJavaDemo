package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: FastJsonTest
 * @Description: fastjson
 * @Author: zhangdi
 * @Date: 2020年09月03日 14:08
 **/
public class FastJsonTest {
    public static void main(String[] args) throws IOException {

        Model model = new Model();
        model.setValue(100);
        String s1 = JSON.toJSONString(model);
        System.out.println(s1);

        Person person = new Person();
        person.setAge(0);
        person.setName("张迪");
        person.setAddress("山东省临沂市");
        person.setBirth(new Date());
        int i = person.hashCode();
        System.out.println("person hashCode=" + i);

        Person person2 = new Person();
        person2.setAge(0);
        person2.setName("张迪");
        person2.setAddress("山东省临沂市");
        person2.setBirth(new Date());
        int i2 = person2.hashCode();
        boolean equals = person2.equals(person);
        System.out.println(equals);


        System.out.println("person2 hashCode=" + i2);
        ArrayList<Person> objects = new ArrayList<>();
        objects.add(person);
        objects.add(person);
        objects.add(person);
        objects.add(person);
        List<Person> people = JSON.parseArray(JSON.toJSONString(objects), Person.class);
        System.out.println(people);
        System.out.println("******");


        String s = JSON.toJSONString(person);
        System.out.println(s);
        JSON.writeJSONString(new FileOutputStream(new File("d:/cg/person.txt")), person, JSON
                .DEFAULT_GENERATE_FEATURE);
    }

    public static class ModelValueSerializer implements ObjectSerializer {
        @Override
        public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
            Integer value = (Integer) o;
            String text = value + "元";
            jsonSerializer.write(text);
        }
    }

    public static class Model {
        @JSONField(serializeUsing = ModelValueSerializer.class)
        int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    static class Person {

        @JSONField(format = "yyyy-MM-dd hh:MM:ss", ordinal = 4)
        Date birth;

        public Date getBirth() {
            return birth;
        }

        public void setBirth(Date birth) {
            this.birth = birth;
        }

        @JSONField(ordinal = 2)
        int age;
        @JSONField(ordinal = 1)
        String name;
        @JSONField(ordinal = 2)
        String address;

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
