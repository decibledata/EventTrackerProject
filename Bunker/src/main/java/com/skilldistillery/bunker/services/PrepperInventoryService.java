package com.skilldistillery.bunker.services;

import java.util.List;

import com.skilldistillery.bunker.entities.PrepperInventory;

public interface PrepperInventoryService {

	List<PrepperInventory> findAll();

	PrepperInventory findById(int id);

	PrepperInventory create(PrepperInventory category);

	PrepperInventory update(int id, PrepperInventory category);

	boolean deleteById(int id);

}
