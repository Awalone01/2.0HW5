package pro.sky2.HW5.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky2.HW5.service.EmployeeService;
import pro.sky2.HW5.data.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/remove{id}")
    public String removeEmployee(@PathVariable("id") Integer id) {
        return employeeService.removeEmployee(id);
    }

    @GetMapping("/get{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeService.getEmployee(id);
    }
}
