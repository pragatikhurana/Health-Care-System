package com.capgemini.healthcaresystem.serviceimpl;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.Appointment;
import com.capgemini.healthcaresystem.dao.DiagnosticCenter;
import com.capgemini.healthcaresystem.dao.Patient;
import com.capgemini.healthcaresystem.exceptions.AppointmentIDException;
import com.capgemini.healthcaresystem.repository.AppointmentRepository;
import com.capgemini.healthcaresystem.repository.DiagnosticCenterRepository;
import com.capgemini.healthcaresystem.repository.PatientRepository;
import com.capgemini.healthcaresystem.service.AppointmentService;

/**
 * This class is to implement all methods from service layer related to Appointment
 * All business Logic related to Appointment is written in methods of this class
 */
@Service 
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired 
	AppointmentRepository appointmentRepository;
	
	@Autowired
	DiagnosticCenterRepository diagnosticCenterRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	/**
	 * This method is overriding the viewAppointmentById method of Appointment Service
	 * */
	@Override
	public Appointment viewAppointmentById(int id) {
		// TODO Auto-generated method stub
		Appointment appointment = appointmentRepository.findAppointmentById(id);
		if(appointment==null) {
			throw new AppointmentIDException("Appointment Id" +id+" does not exists.");
		}
		return appointment;
	}
	
	/**
	 * This method is overriding the update method of Appointment Service
	 * */
	@Override
	public Appointment updateAppointment(Appointment appointment,int appointmentId ) {
		// TODO Auto-generated method stub
		Appointment newAppointment= appointmentRepository.findAppointmentById(appointmentId);
		newAppointment.setApprovalStatus(appointment.getApprovalStatus());
		newAppointment.setAppointmentDate(appointment.getAppointmentDate());
		return appointmentRepository.save(newAppointment);
		
	
	}
	/**
	 * This method is overriding the removeAppointmentById method of Appointment Service
	 * This method is used to remove the appointment by appointment id
	 */
	@Override
	public Appointment removeAppointmentById(int id) {
		// TODO Auto-generated method stub
		Appointment appointment = appointmentRepository.findAppointmentById(id);
		Patient patient = appointment.getPatient();
		DiagnosticCenter diagnosticCenter=appointment.getDiagnosticCenter();
		
		Set<Appointment> ats =  patient.getAppointments();
		Appointment ap=diagnosticCenter.getAppointment();
		
		diagnosticCenterRepository.save(diagnosticCenter);
		ats.remove(appointment);
		
		patientRepository.save(patient);
		
		
		
		appointmentRepository.delete(appointment);
		return appointment;
	}
	/**
	 * This method is overriding the viewAllAppointments method of Appointment Service
	 * */
	@Override
	public Iterable<Appointment> viewAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}
	/**
	 * This method is overriding the save method of Appointment Service
	 * This method will be used to create a new appointment
	 */
	@Override
	public Appointment saveAppointment(Appointment appointment,int diagnosticCenterId,String patientName) {
		// TODO Auto-generated method stub
		try {
			
			if(appointment.getId()==0) {
			DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findById(diagnosticCenterId);
			Patient patient=patientRepository.findByName(patientName);
			appointment.setDiagnosticCenter(diagnosticCenter);
			appointment.setPatient(patient);
			diagnosticCenter.setAppointment(appointment);
			
			
			}
			return appointmentRepository.save(appointment);
		} 
		catch(Exception e) {
			throw new AppointmentIDException("Appointment Id"+appointment.getId()+" already exists");
		}
		
	}
	
}
