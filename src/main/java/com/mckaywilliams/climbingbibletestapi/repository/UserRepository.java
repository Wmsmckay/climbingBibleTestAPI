package com.mckaywilliams.climbingbibletestapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.mckaywilliams.climbingbibletestapi.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByUsername(String username);
	
}
