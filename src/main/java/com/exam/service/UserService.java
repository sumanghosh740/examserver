package com.exam.service;

import java.util.Set;

import com.exam.model.User;
import com.exam.model.UserRole;

public interface UserService {
	
	//Create user
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	//get user by username
	public User getUser(String username) ;
	
	//delete user by userId
	void deleteUser(Long userId);

	//update user
	public User updateUser(User user);

}
