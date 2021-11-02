package com.capgemini.healthcaresystem.service;

import java.util.List;
import java.util.Set;

import com.capgemini.healthcaresystem.dao.DiagnosticTest;
/*
 * Diagnostic Test Service is created here and 
 * will be implemented
 */
public interface DiagnosticTestService {
	List<DiagnosticTest> getAllTest();
	DiagnosticTest addNewTest(DiagnosticTest test,int centerId);
	Set<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId);
	DiagnosticTest updateTestDetail(DiagnosticTest test,String testName);
	DiagnosticTest removeTestFromDiagnosticCenter(String testName);
}
