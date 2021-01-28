package com.mckaywilliams.climbingbibletestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mckaywilliams.climbingbibletestapi.entity.Result;
import com.mckaywilliams.climbingbibletestapi.service.ResultService;

@RestController
@RequestMapping("/users/{userId}/results")
public class ResultsController {
	
	@Autowired
	private ResultService resultService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createResult(@RequestBody Result result, @PathVariable Long userId){
		try {
			return new ResponseEntity<Object>(resultService.createResult(result, userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}
	
	@RequestMapping(value="/{resultId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteResult(@PathVariable Long resultId) {
		try {
			resultService.deleteResult(resultId);
			return new ResponseEntity<Object>("Deleted result with id: " + resultId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping(value="/allresults",method=RequestMethod.GET)
	public ResponseEntity<Object> getAllResults(){
		try {
			return new ResponseEntity<Object>(resultService.getAllResults(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@RequestMapping(value="/{resultId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getResult(@PathVariable Long resultId){
		try {	
			return new ResponseEntity<Object>(resultService.getResult(resultId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateResult(@RequestBody Result result, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(resultService.updateResult(result, id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
}
