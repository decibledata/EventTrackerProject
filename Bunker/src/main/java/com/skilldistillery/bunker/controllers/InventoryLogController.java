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

    @PostMapping
    public InventoryLog createLog(@RequestBody InventoryLog log) {
        return inventoryLogService.create(log);
    }

    @PutMapping("/{id}")
    public InventoryLog updateLog(@PathVariable int id, @RequestBody InventoryLog log) {
        return inventoryLogService.update(id, log);
    }

    @DeleteMapping("/{id}")
    public boolean deleteLog(@PathVariable int id) {
        return inventoryLogService.deleteById(id);
    }
}
