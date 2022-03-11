package pro.sky2.HW5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky2.HW5.data.Employee;
import pro.sky2.HW5.exception.EmployeeExistsException;
import pro.sky2.HW5.exception.EmployeeNotFoundException;
import pro.sky2.HW5.exception.NotLetterException;
import pro.sky2.HW5.service.impl.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky2.HW5.EmployeeServiceConstants.*;


public class EmployeeServiceTest {

    private EmployeeServiceImpl out = new EmployeeServiceImpl();

    @BeforeEach
    public void initialize() {
       out = new EmployeeServiceImpl();
    }

    @Test
    public void shouldAddEmployeeWhenHeDoesntExist() {
        Employee expectedEmployee = new Employee (FIRST_NAME, LAST_NAME);
        assertEquals(0, out.getAllEmployees().size());
        Employee actualEmployee = out.addEmployee (FIRST_NAME, LAST_NAME);
        assertEquals(expectedEmployee, actualEmployee);
        assertEquals(1, out.getAllEmployees().size());
        assertTrue(out.getAllEmployees().contains(expectedEmployee));
    }

    @Test
    public void shouldThrowEmployeeExistsExceptionWhenEmployeeAlreadyExist() {
        Employee expectedEmployee = out.addEmployee (FIRST_NAME, LAST_NAME);
        assertEquals(1, out.getAllEmployees().size());
        assertThrows(EmployeeExistsException.class, () -> out.addEmployee(FIRST_NAME, LAST_NAME));
    }

    public static Stream<Arguments> wrongNames() {
        return Stream.of(
                Arguments.of(FIRST_NAME, WRONG_LAST_NAME),
                Arguments.of(WRONG_FIRST_NAME, LAST_NAME),
                Arguments.of(WRONG_FIRST_NAME, WRONG_LAST_NAME),
                Arguments.of(EMPTY_FIRST_NAME, LAST_NAME),
                Arguments.of(FIRST_NAME, EMPTY_LAST_NAME),
                Arguments.of(EMPTY_FIRST_NAME, EMPTY_LAST_NAME),
                Arguments.of(FIRST_NAME, ONLY_SPACES_LAST_NAME),
                Arguments.of(ONLY_SPACES_FIRST_NAME, LAST_NAME),
                Arguments.of(ONLY_SPACES_FIRST_NAME, ONLY_SPACES_LAST_NAME)
        );
    }

    @ParameterizedTest
    @MethodSource("wrongNames")
    public void shouldThrowsNotLetterException(String firstName, String lastName) {
        assertThrows(NotLetterException.class, () -> out.addEmployee(firstName, lastName));
    }

    @Test
    public void shouldThrowsEmployeeNotFoundExceptionWhenEmployeeDoesntExist() {
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldRemovingEmployeeWhenHeExists() {
        Employee expectedEmployee = out.addEmployee (FIRST_NAME, LAST_NAME);
        assertEquals(1, out.getAllEmployees().size());
        Employee removingEmployee = out.removeEmployee(FIRST_NAME, LAST_NAME);
        assertEquals(0, out.getAllEmployees().size());
        assertFalse(out.getAllEmployees().contains(expectedEmployee));
    }

    @Test
    public void shouldFindEmployeeWhenHeExists() {
        Employee expectedEmployee = out.addEmployee (FIRST_NAME, LAST_NAME);
        assertEquals(1, out.getAllEmployees().size());
        Employee foundEmployee = out.findEmployee(FIRST_NAME, LAST_NAME);
        assertEquals(expectedEmployee, foundEmployee);
        assertTrue(out.getAllEmployees().contains(expectedEmployee));
    }

    @Test
    public void shouldThrowsEmployeeNotFoundExceptionWhenWeSearchEmployeeWhoDoesntExist() {
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(FIRST_NAME, LAST_NAME));
    }

    @Test
    public void shouldReturnEmptyCollectionWhenEmployeeDoesntExists() {
        assertTrue(out.getAllEmployees().isEmpty());
    }

    @Test
    public void shouldReturnCollectionWhenEmployeeExists() {
        Employee expectedEmployee = out.addEmployee (FIRST_NAME, LAST_NAME);
        Collection<Employee> expected = List.of(expectedEmployee);
        assertIterableEquals(expected, out.getAllEmployees());
    }

}
