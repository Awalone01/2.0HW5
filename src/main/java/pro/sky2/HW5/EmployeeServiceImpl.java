package pro.sky2.HW5;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public String addEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public String deletePerson(String firstName, String lastName) {
        return null;
    }

    @Override
    public String searchPerson(String firstName, String lastName) {
        return null;
    }
//    Employee[] employees = {
//            new Employee("Александр", "Волков"),
//            new Employee("Павел", "Петров"),
//            new Employee("Михаил", "Иванов"),
//            new Employee("Олег", "Сидоров")
//    };
//
//    @Override
//    public String addEmployee(String firstName, String lastName) {
//        Employee employee = employees[0];
//        return employee.getFirstName() + employee.getLastName();
//    }

//    @Override
//    public String deletePerson(String firstName, String lastName) {
//        return null;
//    }
//
//    @Override
//    public String searchPerson(String firstName, String lastName) {
//        return null;
//    }
}
