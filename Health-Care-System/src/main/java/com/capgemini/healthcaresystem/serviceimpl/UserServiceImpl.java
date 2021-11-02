package com.capgemini.healthcaresystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.User;
import com.capgemini.healthcaresystem.exceptions.UsernameException;
import com.capgemini.healthcaresystem.repository.UserRepository;
import com.capgemini.healthcaresystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new UsernameException("Username " + user.getUsername() + " already exists");
		}

	}

	@Override
	public User removeUser(User user) {
		try {
			if (userRepository.findById(user.getId()) == null) {
				throw new Exception();
			}
			userRepository.delete(user);
			return user;
		} catch (Exception e) {
			throw new UsernameException("Username " + user.getUsername() + " does not exists");
		}

	}

	@Override
	public User validateUser(String username, String password) {

		try {
			User user = userRepository.findByUsername(username);
			if (user == null) {
				throw new Exception();
			}
			if (user.getPassword().equals(password)) {
				return user;
			} else
				return null;
		} catch (Exception e) {
			throw new UsernameException("Invalid credentials");
		}
	}

}
