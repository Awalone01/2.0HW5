package pro.sky2.HW5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") int salary,
                                @RequestParam("departmentId") int departmentId) {
        return employeeService.addEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("salary") int salary,
                                   @RequestParam("departmentId") int departmentId) {
        return employeeService.removeEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("salary") int salary,
                                 @RequestParam("departmentId") int departmentId) {
        return employeeService.findEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/get")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

}
