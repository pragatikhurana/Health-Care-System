package com.capgemini.healthcaresystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AppointmentIDException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public AppointmentIDException() {
		super();
	}
	public AppointmentIDException(String msg) {
		super(msg);
	}
	
	

}
