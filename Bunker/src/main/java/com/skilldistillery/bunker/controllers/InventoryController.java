package com.skilldistillery.bunker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bunker.entities.Inventory;
import com.skilldistillery.bunker.services.InventoryService;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping
	public List<Inventory> listAllInventory() {
		return inventoryService.findAll();
	}
	
	@GetMapping("/{id}")
	public Inventory findById(@PathVariable("id") int id) {
		return inventoryService.findById(id);
	}
	
	
	@PostMapping
	public Inventory createInventory(@RequestBody Inventory inv) {
		return inventoryService.create(inv);
	}
	
	@PutMapping("/{id}")
	public Inventory updateInventory(@PathVariable("id")int id, Inventory inventory) {
	        return inventoryService.update(id, inventory);
	}
	
	@DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable("id") int id) {
        inventoryService.deleteById(id);
    }
}