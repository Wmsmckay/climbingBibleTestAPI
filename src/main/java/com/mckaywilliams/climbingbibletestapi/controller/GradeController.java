package com.mckaywilliams.climbingbibletestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mckaywilliams.climbingbibletestapi.service.GradeService;

@RestController
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	private GradeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllGrades(){
		return new ResponseEntity<Object>(service.getAllGrades(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{gradeId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getGrade(@PathVariable Long gradeId){
		return new ResponseEntity<Object>(service.getGrade(gradeId), HttpStatus.OK);
	}
	
}
