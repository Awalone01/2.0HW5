package pro.sky2.HW5.repository;

import pro.sky2.HW5.data.Employee;

import java.util.List;

public interface EmployeeRepository {

    String addEmployee(String firstName);

    String removeEmployee(String firstName);

    String findEmployee(String firstName);

    List<String> getAllEmployees();
}
