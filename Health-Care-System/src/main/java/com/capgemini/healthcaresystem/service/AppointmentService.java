package com.capgemini.healthcaresystem.service;

import com.capgemini.healthcaresystem.dao.Appointment;
/**
 * This interface is to declare required methods
 * All methods here will be implemented at another layer
 * All methods contain code related to business logic  
 */
public interface AppointmentService {
	
		
		
		public Appointment viewAppointmentById(int appointmentId);
		public Appointment updateAppointment(Appointment appointment,int appointmentId);
		public Appointment removeAppointmentById(int appointmentId);
		public Iterable<Appointment> viewAllAppointments();
		public Appointment saveAppointment(Appointment appointment,int diagnosticCenterId,String patientName);
}
