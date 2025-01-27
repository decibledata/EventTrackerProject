package com.skilldistillery.bunker.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.User;
import com.skilldistillery.bunker.repositories.UserRepository;
import com.skilldistillery.bunker.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	// GET
	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	// POST
	@Override
	public User create(User user) {
		if (user != null) {
			return userRepo.save(user);
		}
		return null;
	}

	@Override
	public User update(int id, User user) {
		Optional<User> existingUser = userRepo.findById(id);
		if (existingUser.isPresent()) {
			User updatedUser = existingUser.get();
			updatedUser.setUsername(user.getUsername());
			updatedUser.setPassword(user.getPassword());
			updatedUser.setEmail(user.getEmail());

			return userRepo.save(updatedUser);
		}

		return null;
	}

	@Override
	public boolean deleteById(int id) {
		try {
			Optional<User> existingUser = userRepo.findById(id);
			if (existingUser.isPresent()) {
				userRepo.deleteById(id);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error deleting User with ID: " + id, e);
		}
	}
}
