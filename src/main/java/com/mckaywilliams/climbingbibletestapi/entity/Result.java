package com.mckaywilliams.climbingbibletestapi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Result {
	
	private Long resultId;
	private Date date;
	private Long maxFingerStrength;
	private Long maxPullupWeighted;
	private Long coreHanging;
	private Long enduranceHangTime;
	private int score;
	private Grade grade;
	private User user;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getResultId() {
		return resultId;
	}
	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getMaxFingerStrength() {
		return maxFingerStrength;
	}
	public void setMaxFingerStrength(Long maxFingerStrength) {
		this.maxFingerStrength = maxFingerStrength;
	}
	public Long getMaxPullupWeighted() {
		return maxPullupWeighted;
	}
	public void setMaxPullupWeighted(Long maxPullupWeighted) {
		this.maxPullupWeighted = maxPullupWeighted;
	}
	public Long getCoreHanging() {
		return coreHanging;
	}
	public void setCoreHanging(Long coreHanging) {
		this.coreHanging = coreHanging;
	}
	public Long getEnduranceHangTime() {
		return enduranceHangTime;
	}
	public void setEnduranceHangTime(Long enduranceHangTime) {
		this.enduranceHangTime = enduranceHangTime;
	}
	

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@ManyToOne
	@JoinColumn(name = "gradeId")
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	@ManyToOne
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
