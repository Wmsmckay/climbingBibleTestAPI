package com.mckaywilliams.climbingbibletestapi.entity;

import javax.persistence.GeneratedValue;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Grade {
	
	private Long gradeId;
	private int score;
	private String frenchScale;
	private String yds;
	private String boulderVScale;
	
	@JsonIgnore
	private Set<Result> results;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getGradeId() {
		return gradeId;
	}
	public void setGradeId(Long gradeId) {
		this.gradeId = gradeId;
	}
	
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getFrenchScale() {
		return frenchScale;
	}
	public void setFrenchScale(String frenchScale) {
		this.frenchScale = frenchScale;
	}
	public String getYds() {
		return yds;
	}
	public void setYds(String yds) {
		this.yds = yds;
	}
	public String getBoulderVScale() {
		return boulderVScale;
	}
	public void setBoulderVScale(String boulderVScale) {
		this.boulderVScale = boulderVScale;
	}
	
	@OneToMany(mappedBy = "grade")
	public Set<Result> getResults() {
		return results;
	}
	public void setResults(Set<Result> results) {
		this.results = results;
	}

}
