package com.mckaywilliams.climbingbibletestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mckaywilliams.climbingbibletestapi.entity.User;
import com.mckaywilliams.climbingbibletestapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody User user) throws Exception{
		try {
			return new ResponseEntity<Object>(service.createUser(user), HttpStatus.CREATED);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
	public ResponseEntity<Object> login(@RequestBody User user){
		try {
			return new ResponseEntity<Object>(service.login(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value =  "/{id}/results", method = RequestMethod.GET)
	public ResponseEntity<Object> showResults(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getResults(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
		try {
			service.deleteUser(id);
			return new ResponseEntity<Object>("Succefully deleted user: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	//update user
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.updateUser(user, id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
