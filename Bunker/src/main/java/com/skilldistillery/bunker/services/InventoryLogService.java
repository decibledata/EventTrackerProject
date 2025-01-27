package com.skilldistillery.bunker.services;

import java.util.List;

import com.skilldistillery.bunker.entities.InventoryLog;

public interface InventoryLogService {

	List<InventoryLog> findAll();

	InventoryLog create(InventoryLog log);

	InventoryLog update(int id, InventoryLog log);

	boolean deleteById(int id);

}
