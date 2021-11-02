package com.capgemini.healthcaresystem.serviceimpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.DiagnosticCenter;
import com.capgemini.healthcaresystem.dao.DiagnosticTest;
import com.capgemini.healthcaresystem.exceptions.CenterIdNullException;
import com.capgemini.healthcaresystem.exceptions.DiagnosticTestNameException;
import com.capgemini.healthcaresystem.repository.DiagnosticCenterRepository;
import com.capgemini.healthcaresystem.repository.DiagnosticTestRepository;
import com.capgemini.healthcaresystem.service.DiagnosticTestService;
/*
 * Diagnostic Test Service layer is implemented here 
 */
@Service
public class DiagnosticTestServiceImpl implements DiagnosticTestService {
	/*
	 * Diagnostic test repository and diagnostic center repository objects are created
	 */
	@Autowired
	DiagnosticCenterRepository diagnosticCenterRepository;

	@Autowired
	 DiagnosticTestRepository diagnosticTestRepository;
	/*
	 * This method is used to get list of all sets
	 */
	@Override
	public List<DiagnosticTest> getAllTest() {
		return diagnosticTestRepository.findAll();		
	}
	/*
	 * This method is used to add a new test
	 */
	@Override
	public DiagnosticTest addNewTest(DiagnosticTest test,int centerId) {
		try {
			DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findById(centerId);
			test.setDiagnosticCenter(diagnosticCenter);
			return (DiagnosticTest) diagnosticTestRepository.save(test);
		}catch(Exception e) {
			throw new CenterIdNullException("Test center "+centerId+" does not exist.");
		}

	}
	/*
	 * This method is used to get list of all tests
	 * at a given diagnostic center by using its center id
	 */
	@Override
	public Set<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) {
		try {
			DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findById(centerId);
			Set<DiagnosticTest> dts=diagnosticCenter.getTests();
			return dts;
		}catch(Exception e) {
			throw new CenterIdNullException("Test center "+centerId+" does not exist.");
		}
	}
	/*
	 * This method is used to update the details given 
	 * to a given diagnostic test 
	 * by getting the test name as input
	 */
	@Override
	public DiagnosticTest updateTestDetail(DiagnosticTest test,String testName) {
		try {
			DiagnosticTest diagnosticTest = diagnosticTestRepository.findByTestName(test.getTestName());
			diagnosticTest.setTestName(test.getTestName());
			diagnosticTest.setNormalValue(test.getNormalValue());
			diagnosticTest.setTestPrice(test.getTestPrice());
			diagnosticTest.setUnits(test.getUnits());
			diagnosticTest.setDiagnosticCenter(test.getDiagnosticCenter());
			return diagnosticTestRepository.save(diagnosticTest);
		}catch(Exception e) {
			throw new DiagnosticTestNameException("Test name "+testName+" does not exist.");
		}
	}
	/*
	 * Delete the test of a given name
	 */
	@Override
	public DiagnosticTest removeTestFromDiagnosticCenter(String testName) {
		try {
			//finding of an existing diagnostic test
			DiagnosticTest diagnosticTest =  diagnosticTestRepository.findByTestName(testName);
			//Retrieving the diagnostic center info from the found test
			DiagnosticCenter diagnosticCenter = diagnosticTest.getDiagnosticCenter();
			// Getting the specific test and keeping it in the list
			Set<DiagnosticTest> dts =  diagnosticCenter.getTests();
			//removing the test from the list
			dts.remove(diagnosticTest);
			//saving the other information of the diagnostic center
			diagnosticCenterRepository.save(diagnosticCenter);
			//deleting the test from the repository permanently
			diagnosticTestRepository.delete(diagnosticTest);
			return diagnosticTest;
		}catch(Exception e) {
			throw new DiagnosticTestNameException("Test name "+testName+" does not exist.");
		}
		
	}

}
