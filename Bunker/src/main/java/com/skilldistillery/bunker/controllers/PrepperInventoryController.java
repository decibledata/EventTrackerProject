package com.skilldistillery.bunker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.bunker.entities.PrepperInventory;

@RestController
@RequestMapping("api")
public class PrepperInventoryController {

	@Autowired
	private PrepperInventory prepInv;
	
	@GetMapping("prepInv")
	public List<PrepperInventory> listInventory(){
		return prepInv.findAll();
	}
	
}
