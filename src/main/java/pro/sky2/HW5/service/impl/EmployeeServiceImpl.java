package pro.sky2.HW5.service.impl;

import org.springframework.stereotype.Service;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.exception.EmployeeExistsException;
import pro.sky2.HW5.exception.EmployeeNotFoundException;
import pro.sky2.HW5.service.EmployeeService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Set<Employee> employees = new HashSet<>();


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee addingEmployee = new Employee(firstName, lastName);
        if (employees.contains(addingEmployee)) {
            throw new EmployeeExistsException("Этот сотрудник уже добавлен");
        }
        employees.add(addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        Employee removingEmployee = new Employee(firstName, lastName);

        if (!employees.remove(removingEmployee)) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
            return removingEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        Employee findingEmployee = new Employee(firstName, lastName);

        if (!employees.contains(findingEmployee)) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return findingEmployee;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return employees;
    }
}

