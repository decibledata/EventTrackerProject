package com.skilldistillery.bunker.services;

import java.util.List;

import com.skilldistillery.bunker.entities.InventoryLog;

public interface InventoryLogService {

	List<InventoryLog> findAll();

	InventoryLog findById(int id);

	InventoryLog create(InventoryLog inventoryLogs);

	boolean deleteById(int id);

	InventoryLog update(int id, InventoryLog inventoryLogs);

}