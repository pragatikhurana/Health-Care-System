package com.capgemini.healthcaresystem.dao;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This TestResult Class is a domain, which represents data and it will be moving
 * layer to layer.
 * 
 * @author Sameeksha
 *
 */
@Entity
public class TestResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@NotBlank(message="provide testreading")
	/**
	 * TeastReading of the patient
	 */
	private double testReading;
	
	/**
	 * Condition of the patient
	 */
	//@NotBlank(message="provide condition")
	private String condition;
	
	/*
	 * Many to one relations with Appointment
	 */
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "appointmentid", updatable = false, nullable = false)
	@JsonIgnore
	private Appointment appointment;
	
	/**
	 * Default constructor
	 */
	public TestResult()
	{
		
	}
	
	/**
	 * Getters and setters
	 */
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTestReading() {
		return testReading;
	}
	public void setTestReading(double testReading) {
		this.testReading = testReading;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}