package stream;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: PersonBuilder
 * @Description:
 * @Author: zhangdi
 * @Date: 2021年04月23日 10:56
 **/
public final class PersonBuilder {
    private String name;
    private int salary;
    private int age;
    private String sex;
    private String area;

    private PersonBuilder() {
    }

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public PersonBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder withSex(String sex) {
        this.sex = sex;
        return this;
    }

    public PersonBuilder withArea(String area) {
        this.area = area;
        return this;
    }

    public Person build() {
        Person person = new Person();
        person.setName(name);
        person.setSalary(salary);
        person.setAge(age);
        person.setSex(sex);
        person.setArea(area);
        return person;
    }
}
