package com.exam.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	
	//Creating User
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local=this.userRepository.findByUsername(user.getUsername());
		
		if(local!=null) {
			
			System.out.println("User is already there !!");
			throw new Exception("User already present");
			
		}else {
			//user create
			
			for(UserRole ur :userRoles) {
				
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user);
		}
		
		return local;
	}
	
	//getting user by username
	@Override
	public User getUser(String username)  {
		
		
		User user=this.userRepository.findByUsername(username);
		
//		if(user==null) {
//			
//			System.out.println("User not found");
//			throw new Exception("User not found check username");
//		}
		
		return user;
	}
	//deleting user
	
	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}

	
	
	//updating user
	@Override
	public User updateUser(User user) {
		
		Optional<User> updatedUser=this.userRepository.findById(user.getId());
		
//		System.out.println(updatedUser.toString());
		
		if(updatedUser.isPresent()) {
			this.userRepository.save(user);
			
			return user;
		}
		
		return null;
	}

}

















