package com.capgemini.healthcaresystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.healthcaresystem.dao.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
		Admin findByRole(String role);
}

