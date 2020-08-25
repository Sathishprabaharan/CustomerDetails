package CustomerMS.assignment.ExceptionHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerMSExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(SQLException.class)
	public final ResponseEntity<ErrorResp> handleSQLException(SQLException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
        details.add("Service Unavailable - We are working on it");
        ErrorResp error = new ErrorResp("Service Unavailable", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
