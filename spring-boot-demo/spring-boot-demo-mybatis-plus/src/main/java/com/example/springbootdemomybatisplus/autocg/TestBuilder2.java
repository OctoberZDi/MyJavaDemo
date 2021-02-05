package com.example.springbootdemomybatisplus.autocg;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestBuilder2
 * @Description: TestBuilder2
 * @Author: zhangdi
 * @Date: 2020年12月30日 15:29
 **/
public class TestBuilder2 {
    private TestBuilder2() {
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private String name;
        private int age;
        private String num;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder num(String num) {
            this.num = num;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", num='" + num + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Builder builder = TestBuilder2.builder().name("张迪").age(21).num("102030888");
        System.out.println(builder);
        TestBuilder3 build = TestBuilder3.TestBuilder3Builder.aTestBuilder3().withAge(21).build();
    }
}
