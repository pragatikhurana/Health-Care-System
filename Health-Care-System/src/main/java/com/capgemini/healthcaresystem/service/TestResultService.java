package com.capgemini.healthcaresystem.service;

import com.capgemini.healthcaresystem.dao.TestResult;
/**
 * This TestResultService interface will hold the functionality for TestResult Related Business logic
 * @author Sameeksha
 *
 */
public interface TestResultService {
	TestResult addTestResult(TestResult tr,int appointmentid);
	TestResult updateTestResult(TestResult tr,int id);
	void removeTestResult(int id);
	TestResult getById(int id);
	
}
