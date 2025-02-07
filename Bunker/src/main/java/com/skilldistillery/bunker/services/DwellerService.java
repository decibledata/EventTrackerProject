package com.skilldistillery.bunker.services;

import java.util.List;

import com.skilldistillery.bunker.entities.Dweller;

public interface DwellerService {

    List<Dweller> findAll();

    Dweller findById(int id);

    Dweller create(Dweller dweller);

    Dweller update(int id, Dweller dwellerDetails);

    void deleteById(int id);
    
    List<Dweller> findByVaultId(int vaultId);
}