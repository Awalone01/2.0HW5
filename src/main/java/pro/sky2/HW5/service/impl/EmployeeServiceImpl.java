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
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentId) {

        Employee addingEmployee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, departmentId);
        isNotLetter(firstName, lastName);

//        isLetter(firstName, lastName);
//        isAlpha(firstName, lastName);

        if (employees.containsKey(key(firstName, lastName, salary, departmentId))) {
            throw new EmployeeExistsException("Этот сотрудник уже добавлен");
        }
        employees.put(key(firstName, lastName, salary, departmentId), addingEmployee);
        return addingEmployee;
    }

    private void isNotLetter(String... names) {
        Arrays.stream(names).forEach(name -> {
            if (!StringUtils.isAlpha(name)) {
                throw new NotLetterException("Неправильно введены данные");
            }
        });
    }

//    @Override
//    public boolean isLetter(String firstName, String lastName) {
//        return getAllEmployees().stream().
//                filter(employee -> )
//        if (!Character.isLetter()) {
//            throw new NotLetterException("Неправильно введены данные");
//        } return false;
//    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int departmentId) {

        if (!employees.containsKey(key(firstName, lastName, salary, departmentId))) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return employees.remove(key(firstName, lastName, salary, departmentId));
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int salary, int departmentId) {

        if (!employees.containsKey(key(firstName, lastName, salary, departmentId))) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        return employees.get(key(firstName, lastName, salary, departmentId));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public String key(String firstName, String lastName, int salary, int departmentId) {
        return firstName + lastName + salary + departmentId;
    }

//    @Override
//    public boolean isNotLetter(String names) {
//        if (!Character.isLetter(names)) {
//            throw new NotLetterException("Неправильно введены данные");
//        }
//        return false;
//    }

//    @Override
//    public boolean isAlpha(String firstName, String lastName) {
//        return isAlpha(firstName, lastName).matches("[a-zA-Z]+");
//    }

}

