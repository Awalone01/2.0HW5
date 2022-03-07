package pro.sky2.HW5;

import org.junit.jupiter.api.Test;
import pro.sky2.HW5.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pro.sky2.HW5.EmployeeServiceConstants.EMPTY_NAME;

public class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeService();

    @Test
    public void shouldReturnName() {
        String name = out.addEmployee();
        assertTrue(name.contains(EMPTY_NAME));
        assertEquals();
    }
}
