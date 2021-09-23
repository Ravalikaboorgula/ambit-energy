package com.ambit.pojos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class AccountNotFoundException extends RuntimeException {

	private String message;

public AccountNotFoundException(String message) {
	super(message);
	// TODO Auto-generated constructor stub
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}


	
}
