package com.capgemini.healthcaresystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.healthcaresystem.dao.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findById(int id);

	User findByRole(String role);

	User findByUsername(String username);
}