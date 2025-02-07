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

import com.skilldistillery.bunker.entities.Vault;
import com.skilldistillery.bunker.services.VaultService;

@RestController
@RequestMapping("/api/vaults")
@CrossOrigin(origins = "*")
public class VaultController {

    @Autowired
    private VaultService vaultService;

    @GetMapping
    public List<Vault> findAll() {
        return vaultService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vault> findById(@PathVariable("id") int id) {
    	return ResponseEntity.of(vaultService.findById(id));
    }
    
    @PostMapping
    public Vault create(@RequestBody Vault vault) {
        return vaultService.create(vault);
    }


    @PutMapping("/{id}")
    public Vault update(@PathVariable int id, @RequestBody Vault updatedVault) {
        return vaultService.update(id, updatedVault);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        vaultService.deleteById(id);
    }
}

