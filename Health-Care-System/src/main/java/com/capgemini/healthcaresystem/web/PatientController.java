package com.capgemini.healthcaresystem.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.dao.Patient;
import com.capgemini.healthcaresystem.service.MapValidationErrorService;
import com.capgemini.healthcaresystem.service.PatientService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("/add")
	public ResponseEntity<?> addNewPatient(@Valid @RequestBody Patient patient, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Patient savedPatient = patientService.registerPatient(patient);
		return new ResponseEntity<Patient>(savedPatient, HttpStatus.CREATED);
	}

	@PatchMapping("/update")
	public ResponseEntity<?> updatePatient(@Valid @RequestBody Patient patient, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Patient savedPatient = patientService.updatePatientDetails(patient);
		return new ResponseEntity<Patient>(savedPatient, HttpStatus.CREATED);
	}

	@GetMapping("/view/{patientUserName}")
	public ResponseEntity<?> getPatientByName(@Valid @PathVariable String patientUserName) {
		Patient patient = patientService.viewPatient(patientUserName);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

}

