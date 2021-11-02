package com.capgemini.healthcaresystem.exceptions;

public class DiagnosticCenterNameExceptionResponse {
	private String centerName;
	public DiagnosticCenterNameExceptionResponse(String centerName) {
		super();
		this.centerName=centerName;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	

}
