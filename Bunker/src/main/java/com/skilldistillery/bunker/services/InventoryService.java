package com.skilldistillery.bunker.services;

import java.util.List;

import com.skilldistillery.bunker.entities.Inventory;

public interface InventoryService {

	List<Inventory> findAll();

	Inventory findById(int id);

	Inventory create(Inventory inv);

	void deleteById(int id);

	Inventory update(int id, Inventory inventory);

}
