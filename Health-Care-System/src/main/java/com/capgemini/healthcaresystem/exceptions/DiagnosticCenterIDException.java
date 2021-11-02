package com.capgemini.healthcaresystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiagnosticCenterIDException extends RuntimeException{
	
	/**
	 * Exception for Id related to DiagnosticCenter
	 */
	private static final long serialVersionUID = 1L;
	public DiagnosticCenterIDException() {
		super();
	}
	public DiagnosticCenterIDException(String msg) {
		super(msg);
	}


}
