package com.capgemini.healthcaresystem.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * class of diagnostic test
 * 
 * author: Rikth Chakraborty
 */

@Entity
public class DiagnosticTest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	// name of the diagnostic test 
	@NotBlank(message = "Please Include a Test Name")
	String testName;
	
	//Price of the diagnostic test 
	@NotNull(message = "Please Include price of the test")
	Double testPrice;
	
	// normal value of test
	String normalValue;
	
	//units of test 
	String units;
	
	/**
	 * many to one relationship with diagnostic center
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "diagnosticCenter_id", updatable = false, nullable = false)
	@JsonIgnore
	DiagnosticCenter diagnosticCenter;
	
	/**
	 * Constructor without arguments
	 */
	
	public DiagnosticTest() {
		super();
	}
	
	/**
	 * Getters and Setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}


	public Double getTestPrice() { 
		return testPrice; 
	}

	public void setTestPrice(Double testPrice) { 
		this.testPrice = testPrice; 
	}


	public String getNormalValue() {
		return normalValue;
	}

	public void setNormalValue(String normalValue) {
		this.normalValue = normalValue;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}
	public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		this.diagnosticCenter = diagnosticCenter;
	}
	public DiagnosticCenter getDiagnosticCenter() {
		return diagnosticCenter;
	}
	
}
