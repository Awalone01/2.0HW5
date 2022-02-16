package pro.sky2.HW5.service.impl;

import org.springframework.stereotype.Service;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.exception.EmployeeExistsException;
import pro.sky2.HW5.exception.EmployeeNotFoundException;
import pro.sky2.HW5.service.EmployeeMapService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeMapServiceImpl implements EmployeeMapService {

    private Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee addingEmployee = new Employee(firstName, lastName);

        String key = firstName + lastName;

        if (employees.containsKey(key)) {
            throw new EmployeeExistsException("Этот сотрудник уже добавлен");
        }
        employees.put(key, addingEmployee);
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        String key = firstName + lastName;

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        String key = firstName + lastName;

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return employees.get(key);
    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        for (Map.Entry<String, Employee> pair : employees.entrySet()) {
            String key = pair.getKey();
            Employee value = pair.getValue();
            System.out.println(key + ":" + value);
        }
        return employees;
    }
}

