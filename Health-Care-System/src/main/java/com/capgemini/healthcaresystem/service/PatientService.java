package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.dao.Patient;
import com.capgemini.healthcaresystem.dao.TestResult;

public interface PatientService {

	public Patient registerPatient(Patient patient);

	public Patient updatePatientDetails(Patient patient);

	public Patient viewPatient(String name);

	public List<TestResult> getAllTestResult(String patientUsername);

	public TestResult viewTestResult(int testResultId);

}
