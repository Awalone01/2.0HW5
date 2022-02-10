package pro.sky2.HW5.service.impl;

import org.springframework.stereotype.Service;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<Integer, Employee> employees;
    Integer nextId = 0;


    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    private Integer getNextId() {
        Integer result = nextId;
        nextId++;
        return result;
    }

    private String getNotFoundMessage(Integer id) {
        return "Пользователь с id = " + id + " не найден";
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employees.get(id);
    }

    @Override
    public String addEmployee(String firstName, String lastName) {
        employees.put(getNextId(), new Employee(firstName, lastName));
        return "Новый пользователь " + firstName + " " + lastName + " добавлен";
    }

    @Override
    public String removeEmployee(Integer id) {
        if (employees.containsKey(id)) {
            return employees.remove(id).getFirstName();
        } else {
            return getNotFoundMessage(id);
        }
    }
}

