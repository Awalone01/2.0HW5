package pro.sky2.HW5.service;

import pro.sky2.HW5.data.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> getAllEmployees();

    String key (String firstName, String lastName);

}
