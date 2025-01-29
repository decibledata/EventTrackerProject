package com.skilldistillery.bunker.services;

import java.util.List;

import com.skilldistillery.bunker.entities.InventoryItem;

public interface InventoryItemService {

	List<InventoryItem> findAll();

	InventoryItem findById(int id);

	InventoryItem create(InventoryItem inventoryItem);

	InventoryItem update(int id, InventoryItem inventoryItem);

	void deleteById(int id);

}
