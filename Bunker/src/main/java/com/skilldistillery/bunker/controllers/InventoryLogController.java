package com.skilldistillery.bunker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bunker.entities.InventoryLog;
import com.skilldistillery.bunker.services.InventoryLogService;

@RestController
@RequestMapping("api/inventorylogs")
public class InventoryLogController {

	@Autowired
	private InventoryLogService inventoryLogService;

	@GetMapping
	public List<InventoryLog> listAllLogs() {
		return inventoryLogService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<InventoryLog> findById(@PathVariable("id") int id) {
		InventoryLog log = inventoryLogService.findById(id);
		return log != null ? ResponseEntity.ok(log) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<InventoryLog> createInventoryLog(@RequestBody InventoryLog inventoryLog) {
		InventoryLog createdLog = inventoryLogService.create(inventoryLog);
		return ResponseEntity.ok(createdLog);
	}

	@PutMapping("/{id}")
	public ResponseEntity<InventoryLog> updateInventoryLog(@PathVariable("id") int id,
			@RequestBody InventoryLog inventoryLog) {
		InventoryLog updatedLog = inventoryLogService.update(id, inventoryLog);
		return updatedLog != null ? ResponseEntity.ok(updatedLog) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInventoryLog(@PathVariable("id") int id) {
		boolean deleted = inventoryLogService.deleteById(id);
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}