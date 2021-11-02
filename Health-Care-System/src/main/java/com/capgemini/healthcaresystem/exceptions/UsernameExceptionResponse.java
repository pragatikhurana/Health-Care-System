package com.capgemini.healthcaresystem.exceptions;

public class UsernameExceptionResponse {

	private String username;

	public UsernameExceptionResponse() {
		super();
	}

	public UsernameExceptionResponse(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}