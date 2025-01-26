package com.skilldistillery.bunker.services;

import java.util.List;

import com.skilldistillery.bunker.entities.PrepperInventory;

public interface PrepperInventoryService {

	List<PrepperInventory> findAll();

	PrepperInventory findById();

	PrepperInventory create(PrepperInventory newPrep);

	PrepperInventory update(int prepId, PrepperInventory prep);

	boolean deleteById(int prepId);

}
