package com.capgemini.healthcaresystem.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
/**
 * This DiagnosticCenter class is a domain which comprises of all the details in 
 *
 *@author Rajeev
 */
@Entity
public class DiagnosticCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="name cannot be empty")
	@Column(unique = true)
	/*
	 * This is Diagnostic center name
	 */
	private String name;
	/*
	 * This is Diagnostic center contact details
	 */
	@NotBlank(message="contactNo cannot be empty")
	private String contactNo;
	/*
	 * Address of Diagnostic center
	 */
	@NotBlank(message="address cannot be empty")
	private String address;
	/*
	 * ContactEmail of Diagnostic center
	 */
	@NotBlank(message="contactEmail cannot be empty")
	private String contactEmail;
	
	/*
	 * This are services offered 
	 */
	@Column
	@ElementCollection
	private List<String> servicesOffered=new ArrayList<>();
	

	/*
	 * Diagnostic Test is connected to Diagnostic center via one to many relations
	 * 
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "diagnosticCenter",orphanRemoval = true)
	
	private Set<DiagnosticTest> tests=new HashSet<>();
	
	/**
	 * OneToOne mapping with Appointment
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "diagnosticCenter")
	private Appointment appointment;
	/*
	 * Constructor - default
	 */
	public DiagnosticCenter() {
	}
	/*
	 * Getters and Setters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	  public List<String> getServicesOffered() { 
		  return servicesOffered; 
	}
	  public void setServicesOffered(List<String> servicesOffered) { 
		  this.servicesOffered = servicesOffered; 
	}
	  public Set<DiagnosticTest> getTests() {
		return tests;
	}
	  public void setTests(Set<DiagnosticTest> tests) {
		this.tests = tests;
	}
	  public Appointment getAppointment() {
		return appointment;
	}
	  public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	 
	
}
