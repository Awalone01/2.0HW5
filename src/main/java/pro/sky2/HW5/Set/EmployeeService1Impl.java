package pro.sky2.HW5.Set;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class EmployeeService1Impl implements EmployeeService1 {
    Set<String> employeeList;

    public EmployeeService1Impl() {
        employeeList = new HashSet<>();
    }

    @Override
    public boolean addEmployee(String item) {
        return employeeList.add(item);
    }

    @Override
    public boolean removeEmployee(String item) {
        return employeeList.remove(item);
    }

    @Override
    public boolean findEmployee(String item) {
        return employeeList.find(item);
    }

    @Override
    public Set<String> getEmployeeList() {
        return null;
    }
}
