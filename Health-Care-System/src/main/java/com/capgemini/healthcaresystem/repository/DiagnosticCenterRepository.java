package com.capgemini.healthcaresystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.healthcaresystem.dao.DiagnosticCenter;

public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Integer> {
	
	DiagnosticCenter findById(int id);
	DiagnosticCenter findByName(String name);
	
}
