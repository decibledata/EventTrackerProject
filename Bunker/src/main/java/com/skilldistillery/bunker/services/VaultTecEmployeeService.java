package com.skilldistillery.bunker.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.bunker.entities.VaultTecEmployee;

public interface VaultTecEmployeeService {

    List<VaultTecEmployee> findAll();

    Optional<VaultTecEmployee> findById(int id);

    VaultTecEmployee create(VaultTecEmployee employee);

    VaultTecEmployee update(int id, VaultTecEmployee employeeDetails);

    void deleteById(int id);
}