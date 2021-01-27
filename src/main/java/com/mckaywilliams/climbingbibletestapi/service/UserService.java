package com.mckaywilliams.climbingbibletestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mckaywilliams.climbingbibletestapi.entity.User;
import com.mckaywilliams.climbingbibletestapi.repository.UserRepository;
import com.mckaywilliams.climbingbibletestapi.view.allResults;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public User login(User user) throws Exception {
		User foundUser = userRepo.findByUsername(user.getUsername());
		if(foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
			return foundUser;
		} else {
			throw new Exception ("Invalid username or password.");
		}
		
	}
	
	public allResults getResults(Long userId) throws Exception {
		User user = userRepo.findOne(userId);
		if (user == null) {
			throw new Exception("User does not Exist.");
		}
		return new allResults(user);
	}
	
	
	
}
