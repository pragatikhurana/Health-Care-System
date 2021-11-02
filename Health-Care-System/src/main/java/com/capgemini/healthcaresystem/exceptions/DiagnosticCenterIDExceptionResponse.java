package com.capgemini.healthcaresystem.exceptions;

public class DiagnosticCenterIDExceptionResponse {
	private String diagnosticCenterID;
	public DiagnosticCenterIDExceptionResponse(String diagnosticCenterID) {
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
