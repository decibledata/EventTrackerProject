package com.skilldistillery.bunker.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.bunker.entities.Vault;

public interface VaultService {

    List<Vault> findAll();

    Optional<Vault> findById(int id);

    Vault create(Vault vault);

    Vault update(int id, Vault vaultDetails);

    void deleteById(int id);
}
