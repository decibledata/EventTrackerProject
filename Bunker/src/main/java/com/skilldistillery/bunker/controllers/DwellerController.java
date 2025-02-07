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

import com.skilldistillery.bunker.entities.Dweller;
import com.skilldistillery.bunker.services.DwellerService;

@RestController
@RequestMapping("/api/dwellers")
@CrossOrigin(origins = "*")
public class DwellerController {

    @Autowired
    private DwellerService dwellerService;

    @GetMapping
    public List<Dweller> findAllDwellers() {
        return dwellerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dweller> getDwellerById(@PathVariable("id") int id) {
    	Dweller dwell = dwellerService.findById(id);
        return dwell != null ? ResponseEntity.ok(dwell) : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/vault/{vaultId}")
    public ResponseEntity<List<Dweller>> findDwellerByVaultId(@PathVariable("vaultId") int vaultId) {
    	 List<Dweller> dwellers = dwellerService.findByVaultId(vaultId);
    	return dwellers.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(dwellers);
    }

    @PostMapping
    public Dweller createDweller(@RequestBody Dweller dweller) {
        return dwellerService.create(dweller);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dweller> updateDweller(@PathVariable("id") int id, @RequestBody Dweller updatedDweller) {
    	Dweller updated = dwellerService.update(id, updatedDweller);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deleteDweller(@PathVariable("id") int id) {
        dwellerService.deleteById(id);
    }
}
