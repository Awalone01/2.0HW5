package pro.sky2.HW5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/employee")
    public String helloEmployyes() {
        return "Hello!";
    }
//    @GetMapping(path = "/employee")
//    public String addEmployee(@PathVariable("firstName") String firstName,
//                              @PathVariable("lastName") String lastName) {
//        return employeeService.addEmployee(firstName, lastName);
//    }
}
