package com.skilldistillery.bunker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.bunker.entities.Vault;

@Repository
public interface VaultRepository extends JpaRepository<Vault, Integer> {

}
