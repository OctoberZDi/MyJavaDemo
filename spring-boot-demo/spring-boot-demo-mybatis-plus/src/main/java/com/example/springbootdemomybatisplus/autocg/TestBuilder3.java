package com.example.springbootdemomybatisplus.autocg;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: TestBuilder3
 * @Description: testbuilder3
 * @Author: zhangdi
 * @Date: 2020年12月30日 15:34
 **/
public class TestBuilder3 {
    private String name;
    private int age;
    private String num;

    @Override
    public String toString() {
        return "TestBuilder3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", num='" + num + '\'' +
                '}';
    }

    public static final class TestBuilder3Builder {
        private String name;
        private int age;
        private String num;

        private TestBuilder3Builder() {
        }

        public static TestBuilder3Builder aTestBuilder3() {
            return new TestBuilder3Builder();
        }

        public TestBuilder3Builder withName(String name) {
            this.name = name;
            return this;
        }

        public TestBuilder3Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public TestBuilder3Builder withNum(String num) {
            this.num = num;
            return this;
        }

        public TestBuilder3 build() {
            TestBuilder3 testBuilder3 = new TestBuilder3();
            testBuilder3.name = this.name;
            testBuilder3.num = this.num;
            testBuilder3.age = this.age;
            return testBuilder3;
        }

        @Override
        public String toString() {
            return "TestBuilder3Builder{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", num='" + num + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        TestBuilder3 builder3 = TestBuilder3Builder.aTestBuilder3().withName("张迪").withAge(21).withNum("1").build();
        System.out.println(builder3);
    }
}
