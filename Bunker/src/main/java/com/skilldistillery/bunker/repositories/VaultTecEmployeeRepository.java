package com.skilldistillery.bunker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.bunker.entities.VaultTecEmployee;

@Repository
public interface VaultTecEmployeeRepository extends JpaRepository<VaultTecEmployee, Integer> {

}
