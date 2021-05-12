package com.exam.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.helper.UserNotFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		user.setProfile("default.png");
		Set<UserRole> roles =new HashSet<>();
		
		Role role =new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole =new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		
		return this.userService.createUser(user, roles);
	}
	
	//get user
	@GetMapping("/{username}")
	public User getUSer(@PathVariable("username") String username) {
		
		return this.userService.getUser(username);
		
	}
	
	//delete user by id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId")  Long userId) {
		
		this.userService.deleteUser(userId);
	}
	
	//update user by id
	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		
		return this.userService.updateUser(user);
	}
	
	//exception handler
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserPrincipalNotFoundException ex){
		return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
	}
	
}













