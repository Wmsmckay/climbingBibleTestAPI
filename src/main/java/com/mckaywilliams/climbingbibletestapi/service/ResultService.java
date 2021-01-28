package com.mckaywilliams.climbingbibletestapi.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mckaywilliams.climbingbibletestapi.entity.Result;
import com.mckaywilliams.climbingbibletestapi.entity.User;
import com.mckaywilliams.climbingbibletestapi.repository.GradeRepository;
import com.mckaywilliams.climbingbibletestapi.repository.ResultRepository;
import com.mckaywilliams.climbingbibletestapi.repository.UserRepository;

@Service
public class ResultService {
	
	private static final Logger logger = LogManager.getLogger(ResultService.class);
	
	@Autowired
	private ResultRepository resultRepo;
	
	@Autowired
	private GradeRepository gradeRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	// creates a new result for the results table
	public Result createResult(Result result, Long userId) throws Exception {
		try {
			User user = userRepo.findOne(userId);			
			//result.setDate(new Date());
			result.setUser(user);
			return resultRepo.save(result);
		} catch (Exception e) {
			logger.error("Exception occoured while creating result for user: " + userId, e);
			throw new Exception(e);
		}
	}
	
	public Result updateResult(Result result, Long id) throws Exception {
		try {
			Result oldResult = resultRepo.findOne(id);
			oldResult.setCoreHanging(result.getCoreHanging());
			oldResult.setEnduranceHangTime(result.getEnduranceHangTime());
			oldResult.setMaxFingerStrength(result.getMaxFingerStrength());
			oldResult.setMaxPullupWeighted(result.getMaxPullupWeighted());
			oldResult.setGrade(result.getGrade());
			oldResult.setScore(result.getScore());
			oldResult.setDate(result.getDate());
			return resultRepo.save(oldResult);
		} catch (Exception e) {
			logger.error("Exception occoured while updating result: " + id, e);
			throw new Exception("Unable to update Result.");
		}
	}	
	
	
	public void deleteResult(Long resultId) throws Exception {
		try {
			resultRepo.delete(resultId);
		} catch (Exception e) {
			logger.error("Exception occoured while deleting result: " + resultId, e);
			throw new Exception("Unable to Delete Result.");
		}
	}
	
	public Iterable<Result> getAllResults() throws Exception {
		try {
			return resultRepo.findAll();
		} catch (Exception e) {
			logger.error("Exception occoured while getting results.");
			throw new Exception("Unable to get results (No results stored.");
		}
	}
	
	public Result getResult(Long id) throws Exception {
		try {
			return resultRepo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occoured while getting result: " + id );
			throw new Exception("Unable to get result.");
		}
	}
	
}
