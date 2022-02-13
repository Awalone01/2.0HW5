package pro.sky2.HW5.service;

import pro.sky2.HW5.data.Employee;

import java.util.Map;

public interface EmployeeMapService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Map<String, Employee> getAllEmployees();

}
