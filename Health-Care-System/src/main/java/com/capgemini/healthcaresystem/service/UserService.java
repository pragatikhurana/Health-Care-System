package com.capgemini.healthcaresystem.service;

import com.capgemini.healthcaresystem.dao.User;

public interface UserService {
	public User validateUser(String username, String password);

	public User addUser(User user);

	public User removeUser(User user);
}
