package service;

import data.Employee;

import java.util.List;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: IEmployeeService
 * @Description: dd
 * @Author: zhangdi
 * @Date: 2020年05月25日 16:14
 **/
public interface IEmployeeService {

    /**
     * @param employee
     * @return
     */
    //boolean testAge(Employee employee);

    List<Employee> getList(List<Employee> list);
}
