package com.mckaywilliams.climbingbibletestapi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mckaywilliams.climbingbibletestapi.entity.Result;
import com.mckaywilliams.climbingbibletestapi.entity.User;
import com.mckaywilliams.climbingbibletestapi.repository.ResultRepository;
import com.mckaywilliams.climbingbibletestapi.repository.UserRepository;
import com.mckaywilliams.climbingbibletestapi.view.allResults;

@Service
public class UserService {
	
	
	private static final Logger logger = LogManager.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepo;
	
	private ResultRepository resultRepo;
	
	public User createUser(User user) throws Exception {
		try {
			return userRepo.save(user);
		} catch (Exception e) {
			logger.error("Unable to create user with username: " + user.getUsername());
			throw new Exception("User not created.");
		}
	}
	
	public User login(User user) throws Exception {
		User foundUser = userRepo.findByUsername(user.getUsername());
		if(foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
			return foundUser;
		} else {
			logger.error("Invalid login with: -u:" + user.getUsername() + " -p" + user.getPassword());
			throw new Exception ("Invalid username or password.");
		}
	}
	
	
	public User updateUser(User user, Long id) throws Exception{
		try {
			User oldUser = userRepo.findOne(id);
			oldUser.setEmail(user.getEmail());
			oldUser.setFirstName(user.getFirstName());
			oldUser.setLastName(user.getLastName());
			oldUser.setPassword(user.getPassword());
			oldUser.setUsername(user.getUsername());
			oldUser.setWeightKgs(user.getWeightKgs());
			oldUser.setWeightLbs(user.getWeightLbs());			
			return userRepo.save(oldUser);
		} catch (Exception e) {
			logger.error("Error updating user: " + user.getUsername());
			throw new Exception("User cannot be updated.");
		}
	}	
	
	//This is having problems
	public allResults getResults(Long userId) throws Exception {
		try {
			User user = userRepo.findOne(userId);
			return new allResults(user);
		} catch (Exception e) {
			logger.error("Unable to retrieve results for user: " + userId);
			throw new Exception("Results not returned.");
		}
		
//	public Iterable<Result> getResults(Long userId) throws Exception {
//		try {
//			User user = userRepo.findOne(userId);
//			return resultRepo.findAll();
//		} catch (Exception e) {
//			logger.error("Unable to retrieve results for user: " + userId);
//			throw new Exception("Results not returned.");
//		}
		
	}
	
	public void deleteUser(Long id) throws Exception {
		try {
			userRepo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occoured while trying to delete user: " + id, e);
			throw new Exception("Unable to delete user.");
		}
	}
	
}
