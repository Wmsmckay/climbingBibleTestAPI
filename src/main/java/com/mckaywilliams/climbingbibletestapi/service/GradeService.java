package com.mckaywilliams.climbingbibletestapi.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mckaywilliams.climbingbibletestapi.entity.Grade;
import com.mckaywilliams.climbingbibletestapi.entity.User;
import com.mckaywilliams.climbingbibletestapi.repository.GradeRepository;

@Service
public class GradeService {
	
	private static final Logger logger = LogManager.getLogger(GradeService.class);
	
	@Autowired
	private GradeRepository repo;
	
	public Iterable<Grade> getAllGrades() throws Exception {
		try {
			return repo.findAll();
		} catch (Exception e) {
			logger.error("Unable to find grades.");
			throw new Exception("Grades not found.");
		}
	}
	
	public Grade getGrade(Long id) throws Exception{
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Unable to find grade: " + id);
			throw new Exception("Grade not found.");
		}
	}
	
	public Grade createGrade(Grade grade) throws Exception {
		try {
			return repo.save(grade);
		} catch (Exception e) {
			logger.error("Unable to create grade.");
			throw new Exception("Grade not created.");
		}
	}
	
	public Grade updateGrade(Grade grade, Long id) throws Exception {
		try {
			Grade oldGrade = repo.findOne(id);
			oldGrade.setBoulderVScale(grade.getBoulderVScale());
			oldGrade.setFrenchScale(grade.getFrenchScale());
			oldGrade.setYds(grade.getYds());
			oldGrade.setScore(grade.getScore());
			return repo.save(oldGrade);
		} catch (Exception e) {
			logger.error("Unable to update Grade");
			throw new Exception("Grade could not be updates.");
		}
	}
}
