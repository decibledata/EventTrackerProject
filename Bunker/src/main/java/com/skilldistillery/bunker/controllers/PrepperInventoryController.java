package com.skilldistillery.bunker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bunker.entities.PrepperInventory;
import com.skilldistillery.bunker.services.PrepperInventoryService;

@RestController
@RequestMapping("api")
public class PrepperInventoryController {

	@Autowired
	private PrepperInventoryService prepInv;
	
	@GetMapping("prepInv")
	public List<PrepperInventory> listInventory(){
		return prepInv.findAll();
	}
	
}
