package com.mckaywilliams.climbingbibletestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mckaywilliams.climbingbibletestapi.entity.Grade;
import com.mckaywilliams.climbingbibletestapi.entity.Result;
import com.mckaywilliams.climbingbibletestapi.service.GradeService;

@RestController
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	private GradeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllGrades(){
		try{
			return new ResponseEntity<Object>(service.getAllGrades(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{gradeId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getGrade(@PathVariable Long gradeId){
		try{
			return new ResponseEntity<Object>(service.getGrade(gradeId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createGrade(@RequestBody Grade grade){
		try {
			return new ResponseEntity<Object>(service.createGrade(grade), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateGrade(@RequestBody Grade grade, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.updateGrade(grade, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
