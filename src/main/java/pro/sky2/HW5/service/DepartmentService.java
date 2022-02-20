package pro.sky2.HW5.service;

import pro.sky2.HW5.data.Employee;

import java.util.Collection;
import java.util.List;

public interface DepartmentService {

    Employee employeeWithMaxSalary(int department);

    Employee employeeWithMinSalary(int department);

    Collection<Employee> findEmployeesByDepartment(int department);

    List<Employee> findAllEmployees();
}
