package pro.sky2.HW5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.service.DepartmentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee employeeWithMaxSalary(@RequestParam("departmentId") int department) {
        return departmentService.employeeWithMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee employeeWithMinSalary(@RequestParam("departmentId") int department) {
        return departmentService.employeeWithMinSalary(department);
    }

    @GetMapping(path = "/all", params = "departmentsId")
    public Collection<Employee> findEmployeesByDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesByDepartment(department);
    }

    @GetMapping("/all")
    public List<Employee> findAllEmployeesDepartment() {
        return departmentService.findAllEmployees();
    }

}
