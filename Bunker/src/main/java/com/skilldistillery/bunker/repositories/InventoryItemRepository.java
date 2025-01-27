package com.skilldistillery.bunker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bunker.entities.InventoryItem;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer>{

}
