package com.capgemini.healthcaresystem.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.dao.DiagnosticTest;
import com.capgemini.healthcaresystem.service.DiagnosticTestService;
import com.capgemini.healthcaresystem.service.MapValidationErrorService;

/*
 * Controller of the diagnostic test module
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/diagnosticTest")
public class DiagnosticTestController {
	
	@Autowired
	DiagnosticTestService diagnosticTestService;
	
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	/*
	 * Add diagnostic test controller
	 */
	@PostMapping("/{centerId}")
	public ResponseEntity<?> addDiagnosticTest(@Valid @RequestBody DiagnosticTest diagnosticTest, @PathVariable int centerId,BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)
			return errorMap;
		DiagnosticTest savedProject = diagnosticTestService.addNewTest(diagnosticTest,centerId);
		return new ResponseEntity<DiagnosticTest>(savedProject, HttpStatus.CREATED);
	}
	/*
	 * Get all test controller
	 */
	@GetMapping("/list")
	public Iterable<DiagnosticTest> getAllTest(){
		return diagnosticTestService.getAllTest();
	}
	/*
	 * get tests of a center controller
	 */
	@GetMapping("/byCentre/{centreId}")
	public Iterable<DiagnosticTest> getTestsOfDiagnosticCenter(@PathVariable int centreId){
		 return diagnosticTestService.getTestsOfDiagnosticCenter(centreId);
		
	}
	/*
	 * update details controller
	 */
	@PatchMapping("/updateByTestName/{testName}")
	public ResponseEntity<?> updateTestDetail(@Valid @RequestBody DiagnosticTest diagnosticTest,@PathVariable String testName, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap!=null)
			return errorMap;
		DiagnosticTest updateTestDetail= diagnosticTestService.updateTestDetail(diagnosticTest,testName);
		return new ResponseEntity<DiagnosticTest>(updateTestDetail,HttpStatus.OK);
	}
	/*
	 * delete test controller
	 */
	@DeleteMapping("/{testName}")
	public ResponseEntity<?> removeTestFromDiagnosticCenter(@PathVariable String testName ){
	diagnosticTestService.removeTestFromDiagnosticCenter(testName);
	return new ResponseEntity<String>("Diagnostic Center with id : '"+testName+"' is deleted.",HttpStatus.OK);
}
}

