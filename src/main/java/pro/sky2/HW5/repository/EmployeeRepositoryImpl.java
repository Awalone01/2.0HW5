package pro.sky2.HW5.repository;

import org.springframework.stereotype.Repository;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.exception.EmployeeNotFoundException;
import pro.sky2.HW5.exception.EmployeesExistException;
import pro.sky2.HW5.exception.EmployeesNotExistException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Set<String> employees = new HashSet<>();

    @Override
    public String addEmployee(String firstName) {
        if (employees.contains(firstName)) {
            throw new EmployeesExistException();
        }
        employees.add(firstName);
        return null;
    }

    @Override
    public String removeEmployee(String firstName) {
        if (employees.contains(firstName)) {
            employees.remove(firstName);
            return firstName;
        }
        throw new EmployeesNotExistException();
    }

    @Override
    public String findEmployee(String firstName) {
        if (!employees.contains(firstName)) {
            throw new EmployeesNotExistException();
        }
        return firstName;
    }

    @Override
    public List<String> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
