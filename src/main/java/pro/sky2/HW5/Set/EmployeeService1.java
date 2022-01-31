package pro.sky2.HW5.Set;

import java.util.Set;

public interface EmployeeService1 {
    boolean addEmployee(String item);
    boolean removeEmployee(String item);
    boolean findEmployee(String item);


    Set<String> getEmployeeList();
}
