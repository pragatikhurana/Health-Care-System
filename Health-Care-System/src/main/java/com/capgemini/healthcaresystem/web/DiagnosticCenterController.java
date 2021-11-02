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

import com.capgemini.healthcaresystem.dao.DiagnosticCenter;
import com.capgemini.healthcaresystem.service.DiagnosticCenterService;
import com.capgemini.healthcaresystem.service.MapValidationErrorService;
/**
 * This class is used for handling requests and generates json response
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/diagnosticCenter")
public class DiagnosticCenterController {
	
	@Autowired
	DiagnosticCenterService diagnosticCenterService;
	
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	
	/**
	 * Method to add Diagnostic Center 
	 */
	
	@PostMapping("/")
	public ResponseEntity<?> addDiagnosticCenter(@Valid @RequestBody DiagnosticCenter diagnosticCenter,BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		DiagnosticCenter savedProject = diagnosticCenterService.addDiagnosticCenter(diagnosticCenter);
		return new ResponseEntity<DiagnosticCenter>(savedProject, HttpStatus.CREATED);
	}
	/**
	 * This method will give Diagnostic Center based on its diagnosticCenterId
	 * Here diagnostiCenterId is a path variable
	 */
	
	@GetMapping("/{diagnosticCenterId}")
	public ResponseEntity<?> getDiagnosticCenterById(@PathVariable int diagnosticCenterId){
		DiagnosticCenter diagnosticCenter=diagnosticCenterService.getDiagnosticCenterById(diagnosticCenterId);
		return new ResponseEntity<DiagnosticCenter>(diagnosticCenter, HttpStatus.OK);
	}
	
	/**
	 * This method will give Diagnostic Center based on its centerName
	 * Here centerName is a path variable
	 */
	
	@GetMapping("/byName/{centerName}")
	public ResponseEntity<?> getDiagnosticCenterByName(@PathVariable String centerName){
		DiagnosticCenter diagnosticCenter=diagnosticCenterService.getDiagnosticCenter(centerName);
		
		return new ResponseEntity<DiagnosticCenter>(diagnosticCenter, HttpStatus.OK);
	}
	
	/**
	 * Method to get all Diagnostic Centers
	 */
	@GetMapping("/list")
	public Iterable<DiagnosticCenter> getAllDiagnosticCenters(){
		return diagnosticCenterService.getAllDiagnosticCenters();
	}
	
	/**
	 * This method will give Diagnostic Center based on its centerName
	 * Here centerName is a path variable
	 */
	
	@PatchMapping("/updateByName/{centerName}")
	public ResponseEntity<?> updateDiagnosticCenter(@Valid@RequestBody DiagnosticCenter diagnosticCenter,@PathVariable String centerName,BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		DiagnosticCenter updateDiagnosticCenter=diagnosticCenterService.updateDiagnosticCenter(diagnosticCenter,centerName);
		return new ResponseEntity<DiagnosticCenter>(updateDiagnosticCenter, HttpStatus.OK);
		
	}
	/**
	 * Delete the Diagnostic Center by its Id
	 * Here Id is a path variable
	 */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDiagnosticCenter(@PathVariable int id){
		diagnosticCenterService.removeDiagnosticCenter(id);
		return new ResponseEntity<String>("Diagnostic Center with id : '"+id+"' is deleted.",HttpStatus.OK);
	}
}
