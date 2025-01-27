package com.skilldistillery.bunker.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.PrepperInventory;
import com.skilldistillery.bunker.repositories.PrepperInventoryRepository;
import com.skilldistillery.bunker.services.PrepperInventoryService;

@Service
public class PrepperInventoryImpl implements PrepperInventoryService {

	@Autowired
	private PrepperInventoryRepository repo;
	
	@Override
	public List<PrepperInventory> findAll() {
		return repo.findAll();
	}

	@Override
	public PrepperInventory findById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public PrepperInventory create(PrepperInventory category) {
		return repo.save(category);
	}

	@Override
	public PrepperInventory update(int id, PrepperInventory category) {
		if (repo.existsById(id)) {
			category.setId(id);
			return repo.save(category);
		}
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

}
