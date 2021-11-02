package com.capgemini.healthcaresystem.exceptions;

public class NameExceptionResponse {

	private String name;

	public NameExceptionResponse() {
		super();
	}

	public NameExceptionResponse(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
