package com.capgemini.healthcaresystem;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.healthcaresystem.dao.Admin;
import com.capgemini.healthcaresystem.dao.User;
import com.capgemini.healthcaresystem.repository.AdminRepository;
import com.capgemini.healthcaresystem.repository.UserRepository;



@SpringBootApplication
public class HealthCareSystemApplication {

	/*
	 * @Autowired AdminRepository adminRepository;
	 * 
	 * @Autowired UserRepository userRepository;
	 */
	public static void main(String[] args) {
		SpringApplication.run(HealthCareSystemApplication.class, args);
	}
	
	/*
	 * @PostConstruct protected void init() { User user=new User(); Admin admin=new
	 * Admin(); user=createAdmin("Rajeev","Rajeev123","ADMIN");
	 * admin.setRole(user.getRole());
	 * 
	 * admin.setAdminUsers(user);
	 * 
	 * userRepository.save(user);
	 * 
	 * adminRepository.save(admin);
	 * 
	 * }
	 * 
	 * private User createAdmin(String username,String password,String role) { User
	 * user=new User(); user.setUsername(username); user.setPassword(password);
	 * user.setRole(role); return user; }
	 */
	
	

}
