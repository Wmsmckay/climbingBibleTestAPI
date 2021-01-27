package com.mckaywilliams.climbingbibletestapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mckaywilliams.climbingbibletestapi.entity.Grade;
import com.mckaywilliams.climbingbibletestapi.repository.GradeRepository;

@Service
public class GradeService {
	
	@Autowired
	private GradeRepository repo;
	
	public Iterable<Grade> getAllGrades(){
		return repo.findAll();
	}
	
	public Grade getGrade(Long id) {
		return repo.findOne(id);
	}
}
