package com.skilldistillery.bunker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.bunker.entities.Dweller;

@Repository
public interface DwellerRepository extends JpaRepository<Dweller, Integer> {

	List<Dweller> findByVaultId(int vaultId);
}