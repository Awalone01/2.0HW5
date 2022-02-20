package pro.sky2.HW5.service.impl;

import org.springframework.stereotype.Service;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.exception.EmployeeExistsException;
import pro.sky2.HW5.exception.EmployeeNotFoundException;
import pro.sky2.HW5.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentId) {

        Employee addingEmployee = new Employee(firstName, lastName);

        if (employees.containsKey(key(firstName, lastName))) {
            throw new EmployeeExistsException("Этот сотрудник уже добавлен");
        }
        employees.put(key(firstName, lastName), addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int departmentId) {

        if (!employees.containsKey(key(firstName, lastName))) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return employees.remove(key(firstName, lastName));
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int salary, int departmentId) {

        if (!employees.containsKey(key(firstName, lastName))) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return employees.get(key(firstName, lastName));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public String key(String firstName, String lastName) {
        return firstName + lastName;
    }

}

