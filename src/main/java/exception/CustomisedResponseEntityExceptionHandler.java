package exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ambit.project.ambit_energy.pojos.AccountNotFoundException;

@ControllerAdvice
@RestController

public  class CustomisedResponseEntityExceptionHandler extends 
ResponseEntityExceptionHandler
{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request)
	{
		ExceptionResponse exceptionResponse=	new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@ExceptionHandler(AccountNotFoundException.class)
	public final ResponseEntity<Object> handleAccountNotFoundExceptions(Exception ex,WebRequest request)
{
	ExceptionResponse exceptionResponse=	new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
      return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}


}
