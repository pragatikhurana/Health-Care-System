package com.capgemini.healthcaresystem.exceptions;

public class DiagnosticTestNameExceptionResponse {
	private String testName;
	public DiagnosticTestNameExceptionResponse(String testName) {
		super();
		this.testName=testName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	
}
