package com.capgemini.healthcaresystem.dao;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String role;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User adminusers;

	public Admin() {
	}

	public int getId() {
		return id;
	}

	public void setId(int Id) {
		this.id = Id;
	}

	public String getRole() {
		return role;
	}

	public void setAdminUsers(User adminusers) {
		this.adminusers = adminusers;
	}

	public User getUsers() {
		return adminusers;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
