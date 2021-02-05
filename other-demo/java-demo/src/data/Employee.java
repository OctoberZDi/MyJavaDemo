package data;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: User
 * @Description: 用户信息表
 * @Author: zhangdi
 * @Date: 2020年05月25日 15:57
 **/
public class Employee extends Animal implements IPeople {
    public String name;
    private int age;
    private long salary;
    public static String type;

    private static String subType;

    protected String gender;

    private String address;
    private long id;

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Employee.type = type;
    }

    public static String getSubType() {
        return subType;
    }

    public static void setSubType(String subType) {
        Employee.subType = subType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(long id, String name, int age, long salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public void say() {
        System.out.println("hello,man");
    }

    public static final class EmployeeBuilder {
        public static String type;
        private static String subType;
        public String name;
        protected String gender;
        private int age;
        private long salary;
        private String address;
        private long id;

        private EmployeeBuilder() {
        }

        public static EmployeeBuilder anEmployee() {
            return new EmployeeBuilder();
        }

        public EmployeeBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder withSalary(long salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public EmployeeBuilder withSubType(String subType) {
            this.subType = subType;
            return this;
        }

        public EmployeeBuilder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public EmployeeBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee();
            employee.setName(name);
            employee.setAge(age);
            employee.setSalary(salary);
            employee.setType(type);
            employee.setSubType(subType);
            employee.setGender(gender);
            employee.setAddress(address);
            employee.setId(id);
            return employee;
        }
    }
}
