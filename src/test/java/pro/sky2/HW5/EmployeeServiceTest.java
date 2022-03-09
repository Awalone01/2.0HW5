package pro.sky2.HW5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky2.HW5.repository.EmployeeRepository;
import pro.sky2.HW5.service.impl.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pro.sky2.HW5.EmployeeServiceConstants.EMPTY_NAME;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepositoryMock;

    @InjectMocks
    private EmployeeServiceImpl out;

//    private final EmployeeService out = new EmployeeService();
//
    @Test
    public void shouldReturnEmptyName() {
        assertEquals(EMPTY_NAME, out.add);
    }
}
