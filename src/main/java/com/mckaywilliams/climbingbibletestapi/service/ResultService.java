package com.mckaywilliams.climbingbibletestapi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mckaywilliams.climbingbibletestapi.entity.Grade;
import com.mckaywilliams.climbingbibletestapi.entity.Result;
import com.mckaywilliams.climbingbibletestapi.entity.User;
import com.mckaywilliams.climbingbibletestapi.repository.ResultRepository;
import com.mckaywilliams.climbingbibletestapi.repository.UserRepository;

@Service
public class ResultService {
	
	@Autowired
	private ResultRepository resultRepo;
	
	
	@Autowired
	private UserRepository userRepo;
	
	// creates a new result for the results table
	public Result createResult(Result result, Long userId) throws Exception {
		User user = userRepo.findOne(userId);
		if(user == null) {
			throw new Exception("User does not exist.");
		}
		result.setDate(new Date());
		result.setUser(user);
		
		return resultRepo.save(result);
	}
	
	public Result updateResult(Result result, Long id) throws Exception {
		Result foundResult = resultRepo.findOne(id);
		if (foundResult == null) {
			throw new Exception("Result ID:(" + id + ") not found.");
		}
		
		
		// This might not work with multiple options. Try one at a 
		// time maybe if it doesn't work
		foundResult.setCoreHanging(result.getCoreHanging());
		foundResult.setDate(result.getDate());
		foundResult.setEnduranceHangTime(result.getEnduranceHangTime());
		foundResult.setMaxFingerStrength(result.getMaxFingerStrength());
		foundResult.setMaxPullupWeighted(result.getMaxPullupWeighted());
		
		return resultRepo.save(foundResult);
	}
	
	
	public void deleteResult(Long resultId) {
		resultRepo.delete(resultId);
	}
	
	public Iterable<Result> getAllResults(){
		return resultRepo.findAll();
	}
	
	public Result getResult(Long id) {
		return resultRepo.findOne(id);
	}
	
}
