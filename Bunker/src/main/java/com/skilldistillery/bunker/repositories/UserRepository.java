package com.skilldistillery.bunker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bunker.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	
}
