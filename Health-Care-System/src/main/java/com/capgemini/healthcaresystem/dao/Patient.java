package com.capgemini.healthcaresystem.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@NotBlank(message = "name cannot be empty")
	@Column(unique = true, updatable = true)
	private String name;
	@NotBlank(message = "phoneNo cannot be empty")
	private String phoneNo;
	@DecimalMin(value = "0")
	private int age;
	@NotBlank(message = "gender cannot be empty")
	private String gender;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient")
	private Set<Appointment> appointments = null;

	public Patient() {

	}

	
	 public Set<Appointment> getAppointments() { return appointments; }
	 
	 public void setAppointments(Set<Appointment> appointments) {
	this.appointments = appointments; }
	 
	public int getPatientId() {
		return Id;
	}

	public void setPatientId(int pateintId) {
		this.Id = pateintId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
