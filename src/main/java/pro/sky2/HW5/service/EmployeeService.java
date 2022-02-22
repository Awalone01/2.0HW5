package pro.sky2.HW5.service;

import pro.sky2.HW5.data.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int salary, int departmentId);

//    boolean isLetter(String firstNane, String lastName);
//    void isNotLetter(String... names);

    Employee removeEmployee(String firstName, String lastName, int salary, int departmentId);

    Employee findEmployee(String firstName, String lastName, int salary, int departmentId);

    List<Employee> getAllEmployees();

    String key (String firstName, String lastName, int salary, int departmentId);

//    boolean isAlpha(String firstName, String lastName);

}
