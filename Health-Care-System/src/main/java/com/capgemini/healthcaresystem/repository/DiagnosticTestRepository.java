package com.capgemini.healthcaresystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.healthcaresystem.dao.DiagnosticTest;
/*
 * This diagnostic test repository is extending the jpa repository
 */
public interface DiagnosticTestRepository extends JpaRepository<DiagnosticTest, Integer> {
	/*
	 * These methods are manually overridden
	 */
	public List<DiagnosticTest> findAllById(int id);
	public DiagnosticTest findById(int id);
	public DiagnosticTest findByTestName(String testName);
}
