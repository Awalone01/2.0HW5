package pro.sky2.HW5;

import pro.sky2.HW5.data.Employee;

import java.util.List;
import java.util.Set;

public class EmployeeServiceConstants {

    public static final String FIRST_NAME = "Alex";
    public static final String LAST_NAME = "Volkov";

    public static final String FIRST_NAME2 = "Oleg";
    public static final String LAST_NAME2 = "Voronin";

    public static final int MAX_SALARY1 = 2_000;
    public static final int MAX_SALARY2 = 5_000;
    public static final int MIN_SALARY1 = 1_000;
    public static final int MIN_SALARY2 = 3_500;

    public static final int DEPARTMENT_ID1 = 1;
    public static final int DEPARTMENT_ID2 = 2;

    public static final Employee EMPLOYEE1_MAX_SALARY1 = new Employee(FIRST_NAME, LAST_NAME, MAX_SALARY1, DEPARTMENT_ID1);
    public static final Employee EMPLOYEE2_MIN_SALARY1 = new Employee(FIRST_NAME2, LAST_NAME2, MIN_SALARY1, DEPARTMENT_ID1);

    public static final Employee EMPLOYEE1_MAX_SALARY2 = new Employee(FIRST_NAME, LAST_NAME2, MAX_SALARY2, DEPARTMENT_ID2);
    public static final Employee EMPLOYEE2_MIN_SALARY2 = new Employee(FIRST_NAME2, LAST_NAME, MIN_SALARY2, DEPARTMENT_ID2);

    public static final List<Employee> EMPLOYEES_SET = List.of(EMPLOYEE1_MAX_SALARY1, EMPLOYEE2_MIN_SALARY1);
    public static final List<Employee> ALL_EMPLOYEES = List.of(EMPLOYEE1_MAX_SALARY1, EMPLOYEE2_MIN_SALARY1, EMPLOYEE1_MAX_SALARY2, EMPLOYEE2_MIN_SALARY2);

    public static final String WRONG_FIRST_NAME = "Alex0";
    public static final String WRONG_LAST_NAME = "Volkov1";

    public static final String EMPTY_FIRST_NAME = "";
    public static final String EMPTY_LAST_NAME = "";

    public static final String ONLY_SPACES_FIRST_NAME = "   ";
    public static final String ONLY_SPACES_LAST_NAME = "   ";
}
