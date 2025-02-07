package com.skilldistillery.bunker.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.InventoryItem;
import com.skilldistillery.bunker.repositories.InventoryItemRepository;
import com.skilldistillery.bunker.services.InventoryItemService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InventoryItemServiceImpl implements InventoryItemService {

	@Autowired
    private InventoryItemRepository inventoryItemRepo;

	@Override
	public List<InventoryItem> findAll() {
		return inventoryItemRepo.findAll();
	}

	@Override
	public InventoryItem findById(int id) {
		Optional<InventoryItem> inventoryItem = inventoryItemRepo.findById(id);
		return null;
	}

	@Override
	public InventoryItem create(InventoryItem inventoryItem) {
		return inventoryItemRepo.save(inventoryItem);	
				}

	@Override
	public InventoryItem update(int id, InventoryItem inventoryItem) {
		if (inventoryItemRepo.existsById(id)) {
			inventoryItem.setId(id);
			return inventoryItemRepo.save(inventoryItem);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		inventoryItemRepo.deleteById(id);
	}

	@Override
	public List<InventoryItem> findByVaultId(int vaultId) {
		return inventoryItemRepo.findByVaultId(vaultId);
	}


}