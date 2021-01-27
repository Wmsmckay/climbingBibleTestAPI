package com.mckaywilliams.climbingbibletestapi.view;

import java.util.Set;

import com.mckaywilliams.climbingbibletestapi.entity.Result;
import com.mckaywilliams.climbingbibletestapi.entity.User;

public class allResults {
	
	private Set<Result> results;
	
	public allResults(User user) {
		setResults(user.getResults());
	}
	
	
	public Set<Result> getResults() {
		return results;
	}
	public void setResults(Set<Result> results) {
		this.results = results;
	}
}
