package pro.sky2.HW5.service.impl;

import org.springframework.stereotype.Service;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.exception.EmployeeNotFoundException;
import pro.sky2.HW5.service.DepartmentService;
import pro.sky2.HW5.service.EmployeeService;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee employeeWithMaxSalary(int departmentId) {
        return employeeService.getAllEmployees().stream().
                filter(e -> e.getDepartmentId() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Этот сотрудник не найден"));
    }

    @Override
    public Employee employeeWithMinSalary(int departmentId) {
        return employeeService.getAllEmployees().stream().
                filter(e -> e.getDepartmentId() == departmentId)
                .min(comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Этот сотрудник не найден"));
    }

    @Override
    public Employee findEmployeesByDepartment(int department) {
        return null;
    }

    @Override
    public Employee findAllEmployees() {
        return null;
    }





//    public static float allSalary() {
//        float sum = 0;
//        for (Employee employee:employees) {
//            if (employee != null) {
//                sum += employee.getSalary();
//            }
//        }
//        return sum;
//    }
//
//    public static Employee employeeWithMaxSalary() {
//        Employee result = null;
//        float maxSalary = Integer.MIN_VALUE;
//        for (Employee employee:employees) {
//            if (employee != null && employee.getSalary() > maxSalary) {
//                maxSalary = employee.getSalary();
//                result = employee;
//            }
//        }
//        return result;
//    }
//
//    public static Employee employeeWithMinSalary() {
//        Employee result = null;
//        float minSalary = Integer.MAX_VALUE;
//        for (Employee employee:employees) {
//            if (employee != null && employee.getSalary() < minSalary) {
//                minSalary = employee.getSalary();
//                result = employee;
//            }
//        }
//        return result;
//    }

}
