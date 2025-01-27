package com.skilldistillery.bunker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bunker.entities.PrepperInventory;
import com.skilldistillery.bunker.services.PrepperInventoryService;

@RestController
@RequestMapping("api")
public class PrepperInventoryController {

	@Autowired
	private PrepperInventoryService service;
	
	@GetMapping("prepInv")
	public List<PrepperInventory> index(){
		return service.findAll();
	}
	
	@GetMapping("{id}")
	  public ResponseEntity<PrepperInventory> show(@PathVariable int id) {
        PrepperInventory category = service.findById(id);
        if (service != null) {
            return ResponseEntity.ok(category);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
}
