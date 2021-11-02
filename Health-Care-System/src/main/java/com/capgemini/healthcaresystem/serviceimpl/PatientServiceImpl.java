package com.capgemini.healthcaresystem.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.Appointment;
import com.capgemini.healthcaresystem.dao.Patient;
import com.capgemini.healthcaresystem.dao.TestResult;
import com.capgemini.healthcaresystem.exceptions.NameException;
import com.capgemini.healthcaresystem.repository.PatientRepository;
import com.capgemini.healthcaresystem.repository.TestResultRepository;
import com.capgemini.healthcaresystem.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private TestResultRepository testResultRepositroy;

	@Override
	public Patient registerPatient(Patient patient) {
		try {
			Set<Appointment> appointments = new HashSet<Appointment>();
			patient.setAppointments(appointments);
			return patientRepository.save(patient);
		} catch (Exception e) {
			throw new NameException("Patient " + patient.getName() + " already exists");
		}
	}

	@Override
	public Patient updatePatientDetails(Patient patient) {
		patient.setPatientId(patientRepository.findByName(patient.getName()).getPatientId());
		patient.setAppointments(patientRepository.findByName(patient.getName()).getAppointments());
		return patientRepository.save(patient);
	}

	@Override
	public Patient viewPatient(String patientUserName) {
		Patient patient = patientRepository.findByName(patientUserName);
		if (patient == null) {
			throw new NameException("Patient name : " + patientUserName + " does not exists");
		}
		return patient;
	}

	@Override
	public List<TestResult> getAllTestResult(String patientUsername) {
		try {
			List<TestResult> testResult = new ArrayList<TestResult>();

			Patient patient = patientRepository.findByName(patientUsername);

			if (patient == null) {
				throw new NameException("Patient name : " + patientUsername + " does not exists");
			}

			Set<Appointment> appointments = patient.getAppointments();
			if (appointments == null) {
				throw new Exception("Patient does not have any appointments yet");
			}

			for (Appointment abstractAppointment : appointments) {
				if (abstractAppointment.getTestresults() != null) {
					testResult.addAll(abstractAppointment.getTestresults());
				}
			}

			return testResult;
		} catch (Exception e) {
			throw new NameException(e.getMessage());
		}
	}

	@Override
	public TestResult viewTestResult(int testResultId) {
		TestResult testResult = testResultRepositroy.findById(testResultId);
		if (testResult == null) {
			throw new NameException("Test doesn't exist");
		}
		return testResult;
	}

}
