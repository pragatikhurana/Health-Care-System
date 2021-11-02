package com.capgemini.healthcaresystem.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.dao.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
	Patient findByName(String name);
	
}