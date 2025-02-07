package com.skilldistillery.bunker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.bunker.entities.InventoryItem;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer> {
	List<InventoryItem> findByVaultId(int vaultId);
}
