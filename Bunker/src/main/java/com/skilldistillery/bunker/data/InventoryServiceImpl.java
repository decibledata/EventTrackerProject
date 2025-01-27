package com.skilldistillery.bunker.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.Inventory;
import com.skilldistillery.bunker.repositories.InventoryRepository;
import com.skilldistillery.bunker.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepo;

    @Override
    public List<Inventory> findAll() {
        return inventoryRepo.findAll();
    }

    @Override
    public Inventory findById(int id) {
        Optional<Inventory> inventory = inventoryRepo.findById(id);
        return inventory.orElse(null);
    }

    @Override
    public Inventory create(Inventory inventory) {
        return inventoryRepo.save(inventory);
    }

    @Override
    public Inventory update(int id, Inventory inventory) {
        if (inventoryRepo.existsById(id)) {
            inventory.setId(id);
            return inventoryRepo.save(inventory);
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        inventoryRepo.deleteById(id);
    }

}
