package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.dao.DiagnosticCenter;

/**
 * This interface is to declare required methods
 * All methods here will be implemented at another layer
 * All methods contain code related to business logic  
 */
public interface DiagnosticCenterService {
	
	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId);
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter,String centerName);
	
	public DiagnosticCenter getDiagnosticCenter(String centerName);
	public DiagnosticCenter removeDiagnosticCenter(int id);
	

}
