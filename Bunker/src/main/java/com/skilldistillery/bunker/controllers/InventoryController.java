package com.skilldistillery.bunker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Inventory> findById(@PathVariable("id") int id) {
		Inventory inventory = inventoryService.findById(id);
		if (inventory == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inv) {
		try {
			inv = inventoryService.create(inv);
			return new ResponseEntity<>(inv, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable("id") int id, @RequestBody Inventory inventory) {
		Inventory updatedInventory = inventoryService.update(id, inventory);
		if (updatedInventory == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInventory(@PathVariable("id") int id) {
		if (inventoryService.deleteById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}