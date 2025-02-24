package com.skilldistillery.bunker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bunker.entities.InventoryItem;
import com.skilldistillery.bunker.services.InventoryItemService;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "*")
public class InventoryItemController {

	@Autowired
	private InventoryItemService inventoryService;

	@GetMapping
	public List<InventoryItem> listAllInventoryItems() {
		return inventoryService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<InventoryItem> findById(@PathVariable("id") int id) {
		InventoryItem item = inventoryService.findById(id);
		return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
	}

	@GetMapping("/vault/{vaultId}")
	public List<InventoryItem> getInventoryByVaultId(@PathVariable("vaultId") int vaultId) {
		return inventoryService.findByVaultId(vaultId);
	}

	@PostMapping
	public InventoryItem createInventoryItem(@RequestBody InventoryItem inventoryItem) {
		return inventoryService.create(inventoryItem);
	}

	@PutMapping("/{id}")
	public InventoryItem updateInventoryItem(@PathVariable("id") int id, @RequestBody InventoryItem inventoryItem) {
		return inventoryService.update(id, inventoryItem);
	}

	@DeleteMapping("/{id}")
	public void deleteInventoryItem(@PathVariable("id") int id) {
		inventoryService.deleteById(id);
	}

}
