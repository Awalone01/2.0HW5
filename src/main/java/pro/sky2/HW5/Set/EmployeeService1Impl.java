package pro.sky2.HW5.Set;

import java.util.HashSet;
import java.util.Set;

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
        return employeeList;
    }

    @Override
    public Set<String> getShoppingList() {
        return null;
    }
}
