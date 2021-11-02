package com.capgemini.healthcaresystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.healthcaresystem.dao.TestResult;

public interface TestResultRepository extends JpaRepository<TestResult, Integer> {
	TestResult findById(int id);
	TestResult findByTestReading(double testReading);
	
}
