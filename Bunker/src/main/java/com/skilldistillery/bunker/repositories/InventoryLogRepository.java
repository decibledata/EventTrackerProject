package com.skilldistillery.bunker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bunker.entities.InventoryLog;

public interface InventoryLogRepository extends JpaRepository<InventoryLog, Integer> {

}
