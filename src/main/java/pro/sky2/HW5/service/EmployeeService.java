package pro.sky2.HW5.service;

import pro.sky2.HW5.data.Employee;

public interface EmployeeService {
    Employee getEmployee(Integer id);

    String addEmployee(String firstName, String lastName);

    String removeEmployee(Integer id);

}
