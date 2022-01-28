package pro.sky2.HW5;

public interface EmployeeService {
    String addEmployee(String firstName, String lastName);
    String deletePerson(String firstName, String lastName);
    String searchPerson(String firstName, String lastName);

}
