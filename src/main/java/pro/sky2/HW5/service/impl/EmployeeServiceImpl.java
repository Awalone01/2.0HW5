package pro.sky2.HW5.service.impl;

import org.springframework.stereotype.Service;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.exception.EmployeeArrayFullException;
import pro.sky2.HW5.exception.EmployeeExistsException;
import pro.sky2.HW5.exception.EmployeeNotFoundException;
import pro.sky2.HW5.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Employee[] employees = new Employee[2];

    private int size;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.length == size) {
            throw new EmployeeArrayFullException("Массив сотрудников заполнен");
        }

        Employee addingEmployee = new Employee(firstName, lastName);
        int addingEmployeeIndex = getEmployeeIndex(addingEmployee);

        if (addingEmployeeIndex != -1) {
            throw new EmployeeExistsException("Этот сотрудник уже добавлен");
        }
        employees[size++] = addingEmployee;
        return addingEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee removingEmployee = new Employee(firstName, lastName);
        int employeeIndex = getEmployeeIndex(removingEmployee);

        if (employeeIndex == -1) {
            throw new EmployeeNotFoundException("Этот сотрудник не найден");
        }
        Employee removedEmployee = employees[employeeIndex];
        System.arraycopy(employees, employeeIndex + 1, employees, employeeIndex, size - employeeIndex);
        size--;
        return removedEmployee;
    }

    private int getEmployeeIndex(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employee.equals(employees[i])) {
                return i;
            }
        }
        return -1;
    }

        @Override
        public Employee findEmployee (String firstName, String lastName){
            Employee findingEmployee = new Employee(firstName, lastName);
            int employeeIndex = getEmployeeIndex(findingEmployee);

            if (employeeIndex == -1) {
                throw new EmployeeNotFoundException("Этот сотрудник не найден");
            }
            return employees[employeeIndex];
        }
    }

