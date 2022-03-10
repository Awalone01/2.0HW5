package pro.sky2.HW5;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky2.HW5.service.EmployeeService;
import pro.sky2.HW5.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeServiceImpl out;

}
