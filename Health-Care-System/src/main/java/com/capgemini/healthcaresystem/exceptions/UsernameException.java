package com.capgemini.healthcaresystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This will create ProjectIDException object without error message
	 */
	public UsernameException() {
		super();
	}

	/**
	 * This will create ProjectIDException object with error message
	 */
	public UsernameException(String msg) {
		super(msg);
	}

}