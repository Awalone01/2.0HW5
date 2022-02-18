package pro.sky2.HW5.service;


import pro.sky2.HW5.data.Employee;

public interface DepartmentService {

    Employee employeeWithMaxSalary(int department);

    Employee employeeWithMinSalary(int department);

    Employee findEmployeesByDepartment(int department);

    Employee findAllEmployees();
}
