package pro.sky2.HW5.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class EmployeeController1 {
    private final EmployeeService1 employeeService1;


    public EmployeeController1(EmployeeService1 employeeService1) {
        this.employeeService1 = employeeService1;
    }

    @GetMapping(path = "/post/employee-list/")
    public boolean addEmployee(@RequestParam("item") String item) {
        return employeeService1.addEmployee(item);
    }

    @GetMapping(path = "/delete/employee-list/")
    public boolean removeEmployeeList(@RequestParam("item") String item) {
        return employeeService1.removeEmployee(item);
    }

    @GetMapping(path = "/find/employee-list/")
    public boolean findEmployee(@RequestParam("item") String item) {
        return employeeService1.findEmployee(item);
    }

    @GetMapping(path = "/get/employee-list")
    public Set<String> getEmployeeList() {
        return employeeService1.getEmployeeList();
    }
}
