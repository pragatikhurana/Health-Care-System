package com.capgemini.healthcaresystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.healthcaresystem.dao.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	Appointment findAppointmentById(int id);
	Appointment findByDiagnosticCenterName(String name);

}
