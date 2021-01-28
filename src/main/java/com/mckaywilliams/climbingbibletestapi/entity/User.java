package com.mckaywilliams.climbingbibletestapi.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	
	private Long userId;
	private String password;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	
	@JsonIgnore
	private Set<Result> results;
	
	private Long weightLbs;
	private Long weightKgs;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getWeightLbs() {
		return weightLbs;
	}
	public void setWeightLbs(Long weightLbs) {
		this.weightLbs = weightLbs;
	}
	public Long getWeightKgs() {
		return weightKgs;
	}
	public void setWeightKgs(Long weightKgs) {
		this.weightKgs = weightKgs;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy= "user")
	public Set<Result> getResults() {
		return results;
	}
	public void setResults(Set<Result> results) {
		this.results = results;
	}
	
	
	
}
