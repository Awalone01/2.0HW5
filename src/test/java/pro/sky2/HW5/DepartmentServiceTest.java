package pro.sky2.HW5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky2.HW5.exception.EmployeeNotFoundException;
import pro.sky2.HW5.service.EmployeeService;
import pro.sky2.HW5.service.impl.DepartmentServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky2.HW5.EmployeeServiceConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldReturnEmployeeWithMaxSalary() {
        when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES_SET);
        assertEquals(EMPLOYEE1_MAX_SALARY1, out.employeeWithMaxSalary(DEPARTMENT_ID1));
    }

    @Test
    public void shouldThrowsEmployeeNotFoundExceptionByMaxSalaryWhenDepartmentIsEmpty() {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        assertThrows(EmployeeNotFoundException.class, () -> out.employeeWithMaxSalary(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnEmployeeWithMinSalary() {
        when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES_SET);
        assertEquals(EMPLOYEE2_MIN_SALARY1, out.employeeWithMinSalary(DEPARTMENT_ID1));
    }

    @Test
    public void shouldThrowsEmployeeNotFoundExceptionByMinSalaryWhenDepartmentIsEmpty() {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        assertThrows(EmployeeNotFoundException.class, () -> out.employeeWithMinSalary(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnCollectionByDepartmentIdWhenEmployeesExist() {
        when(employeeService.getAllEmployees()).thenReturn(ALL_EMPLOYEES);
        assertEquals(List.of(EMPLOYEE1_MAX_SALARY1, EMPLOYEE2_MIN_SALARY1), out.findEmployeesByDepartment(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnEmptyCollectionByDepartmentIdWhenEmployeesDontExist() {
        when(employeeService.getAllEmployees()).thenReturn(EMPLOYEES_SET);
        assertEquals(new ArrayList<>(), out.findEmployeesByDepartment(DEPARTMENT_ID2));
    }

    @Test
    public void shouldReturnAllEmployees() {
        when(employeeService.getAllEmployees()).thenReturn(ALL_EMPLOYEES);
        assertEquals(ALL_EMPLOYEES, out.findAllEmployees());
    }

    @Test
    public void shouldReturnEmptyCollectionWhenEmployeesDontExist() {
        when(employeeService.getAllEmployees()).thenReturn(new ArrayList<>());
        assertEquals(new ArrayList<>(), out.findAllEmployees());
    }


}
