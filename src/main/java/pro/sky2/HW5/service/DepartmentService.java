package pro.sky2.HW5.service;

import pro.sky2.HW5.data.Employee;

import java.util.Collection;
import java.util.List;

public interface DepartmentService {

    Employee employeeWithMaxSalary(int departmentId);

    Employee employeeWithMinSalary(int departmentId);

    Collection<Employee> findEmployeesByDepartment(int departmentId);

    List<Employee> findAllEmployees();
}
