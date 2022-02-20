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
    public Employee employeeWithMaxSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.employeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee employeeWithMinSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.employeeWithMinSalary(departmentId);
    }

    @GetMapping(path = "/all", params = "departmentsId")
    public Collection<Employee> findEmployeesByDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentService.findEmployeesByDepartment(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> findAllEmployeesDepartment() {
        return departmentService.findAllEmployees();
    }

}
