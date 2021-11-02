package com.capgemini.healthcaresystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiagnosticTestNameException extends RuntimeException{
	/**
	 * Exception class of non availability of test name 
	 */
	private static final long serialVersionUID = 1L;
	public DiagnosticTestNameException() {
		super();
	}
	public DiagnosticTestNameException(String message) {
		super(message);
	}
}
