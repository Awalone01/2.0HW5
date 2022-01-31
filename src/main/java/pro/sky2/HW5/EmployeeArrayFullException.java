package pro.sky2.HW5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeArrayFullException extends RuntimeException {

    public EmployeeArrayFullException(String massage) {
        super(massage);
    }
}
