package pro.sky2.HW5.service.impl;

import org.springframework.stereotype.Service;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.exception.EmployeeNotFoundException;
import pro.sky2.HW5.service.DepartmentService;
import pro.sky2.HW5.service.EmployeeService;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Этот сотрудник не найден"));
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int department) {
        return employeeService.getAllEmployees().stream().
                filter(employee -> employee.getDepartmentId() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeService.getAllEmployees().stream().
                collect(Collectors.toList());
    }
}
