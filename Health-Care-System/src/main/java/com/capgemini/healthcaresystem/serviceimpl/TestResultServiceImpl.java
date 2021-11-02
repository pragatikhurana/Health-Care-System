package com.capgemini.healthcaresystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.Appointment;
import com.capgemini.healthcaresystem.dao.TestResult;
import com.capgemini.healthcaresystem.exceptions.TestResultIdException;
import com.capgemini.healthcaresystem.repository.AppointmentRepository;
import com.capgemini.healthcaresystem.repository.TestResultRepository;
import com.capgemini.healthcaresystem.service.TestResultService;


/**
 * This class will implement the Test Result
 * related business logics
 */
@Service
public class TestResultServiceImpl implements TestResultService {

	@Autowired
	private TestResultRepository testRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Override
	/**
	 * This method is overriding the add method of Test Result Service
	 */
	public TestResult addTestResult(TestResult tr ,int appointmentid){	
		
			try {
			Appointment appointment=appointmentRepository.findAppointmentById(appointmentid);
			tr.setAppointment(appointment);
		   
		return testRepository.save(tr);
	}
	catch (Exception e) {
	 throw new TestResultIdException("TestResult Id already exists");
	}
		
	}
	/**
	 * This method is overriding the update method of Test Result Service using Id
	 */
	@Override
	public TestResult updateTestResult(TestResult tr,int id) {
		try {
		TestResult current=testRepository.findById(id);
		current.setTestReading(tr.getTestReading());
		current.setCondition(tr.getCondition());
		TestResult Update=testRepository.save(current);
		return Update;
	}
	catch(Exception e)
	{
		throw new TestResultIdException("TestResult Id not found");
	}
		
		
	}
	/**
	 * This method is overriding the remove method of Test Result Service using Id
	 */
	@Override
	public void removeTestResult(int id) {
		try {
		TestResult testResult=  testRepository.findById(id);
		
		Appointment appointment = testResult.getAppointment();
		
		List<TestResult> tts =  appointment.getTestresults();
		
		tts.remove(testResult);
		
		appointmentRepository.save(appointment);
		
		testRepository.delete(testResult);
		}
		catch(Exception e)
		{
			throw new TestResultIdException("TestResult Id not found");
		}
		
		
	}
	/**
	 * This method is overriding the get method of Test Result Service
	 */
	@Override
	public TestResult getById(int id) {
		TestResult tr=testRepository.findById(id);
		return tr;
	}

	
}
