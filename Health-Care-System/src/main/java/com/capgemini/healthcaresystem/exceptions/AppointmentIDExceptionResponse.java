package com.capgemini.healthcaresystem.exceptions;

public class AppointmentIDExceptionResponse {
	private String id;
	
	public  AppointmentIDExceptionResponse(String id) {
		super();
		this.id= id;
		}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}


