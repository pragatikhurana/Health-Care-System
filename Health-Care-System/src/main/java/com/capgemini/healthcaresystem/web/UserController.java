package com.capgemini.healthcaresystem.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.dao.User;
import com.capgemini.healthcaresystem.service.MapValidationErrorService;
import com.capgemini.healthcaresystem.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	MapValidationErrorService mapValidationErrorService;

	@PostMapping("/add")
	public ResponseEntity<?> addNewUser(@Valid @RequestBody User user, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		User savedUser = userService.addUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}

	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody Map<String, String> json, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		User validUser = userService.validateUser(json.get("username"), json.get("password"));
		if (validUser == null) {
			return new ResponseEntity<String>("Invalid user credentials", HttpStatus.OK);
		}
		return new ResponseEntity<User>(validUser, HttpStatus.OK);
	}

	@DeleteMapping("/remove")
	public ResponseEntity<?> deleteUser(@Valid @RequestBody User user, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		user = userService.removeUser(user);
		if (user == null) {
			return new ResponseEntity<String>("User with username : " + user.getUsername() + " doesn't exist",
					HttpStatus.OK);
		}
		return new ResponseEntity<String>("User with username : " + user.getUsername() + " is deleted.", HttpStatus.OK);
	}
}