package pro.sky2.HW5.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.exception.EmployeeExistsException;
import pro.sky2.HW5.exception.EmployeeNotFoundException;
import pro.sky2.HW5.exception.NotLetterException;
import pro.sky2.HW5.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee addingEmployee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
        isNotLetter(firstName, lastName);

        if (employees.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeExistsException("Этот сотрудник уже добавлен");
        }
        employees.put(getKey(firstName, lastName), addingEmployee);
        return addingEmployee;
    }

    private void isNotLetter(String... names) {
        Arrays.stream(names).forEach(name -> {
            if (!StringUtils.isAlpha(name)) {
                throw new NotLetterException("Неправильно введены данные");
            }
        });
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        if (!employees.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return employees.remove(getKey(firstName, lastName));
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        if (!employees.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return employees.get(getKey(firstName, lastName));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}

