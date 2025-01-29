package com.skilldistillery.bunker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bunker.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}