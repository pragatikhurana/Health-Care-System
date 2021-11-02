package com.capgemini.healthcaresystem.exceptions;

public class CenterIdNullExceptionResponse {
	private String diagnosticCenterID;
	public CenterIdNullExceptionResponse(String diagnosticCenterID) {
		super();
		this.diagnosticCenterID=diagnosticCenterID;
	}
	public String getDiagnosticCenterID() {
		return diagnosticCenterID;
	}
	public void setDiagnosticCenterID(String diagnosticCenterID) {
		this.diagnosticCenterID = diagnosticCenterID;
	}
}