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

import com.skilldistillery.bunker.entities.VaultTecEmployee;
import com.skilldistillery.bunker.services.VaultTecEmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class VaultTecEmployeeController {

    @Autowired
    private VaultTecEmployeeService employeeService;

    @GetMapping
    public List<VaultTecEmployee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaultTecEmployee> findById(@PathVariable("id") int id) {
    	return ResponseEntity.of(employeeService.findById(id));
    }
    
    @PostMapping
    public VaultTecEmployee create(@RequestBody VaultTecEmployee employee) {
        return employeeService.create(employee);
    }


    @PutMapping("/{id}")
    public VaultTecEmployee update(@PathVariable("id") int id, @RequestBody VaultTecEmployee updatedEmployee) {
        return employeeService.update(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        employeeService.deleteById(id);
    }
}

