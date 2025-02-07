package com.skilldistillery.bunker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.skilldistillery.bunker.entities.Overseer;
import com.skilldistillery.bunker.services.OverseerService;

@RestController
@RequestMapping("/api/overseers")
@CrossOrigin(origins = "*")
public class OverseerController {

	@Autowired
	private OverseerService overseerService;

	@GetMapping
	public List<Overseer> index() {
		return overseerService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Overseer> show(@PathVariable("id") int id) {
		Overseer overseer = overseerService.findById(id);
		if (overseer != null) {
			return new ResponseEntity<>(overseer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Overseer> create(@RequestBody Overseer overseer) {
		Overseer created = overseerService.create(overseer);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Overseer> update(@PathVariable("id") int id, @RequestBody Overseer updatedOverseer) {
		Overseer updated = overseerService.update(id, updatedOverseer);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		overseerService.deleteById(id);
		return null;
		}
	}
