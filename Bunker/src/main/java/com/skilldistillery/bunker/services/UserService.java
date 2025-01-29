package com.skilldistillery.bunker.services;

import java.util.List;

import com.skilldistillery.bunker.entities.User;

public interface UserService {

	List<User> findAll();

	User create(User user);

	User update(int id, User user);

	boolean deleteById(int id);

}