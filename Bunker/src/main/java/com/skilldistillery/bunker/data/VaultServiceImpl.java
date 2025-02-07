package com.skilldistillery.bunker.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.Vault;
import com.skilldistillery.bunker.repositories.VaultRepository;
import com.skilldistillery.bunker.services.VaultService;

@Service
public class VaultServiceImpl implements VaultService {

	@Autowired
    private VaultRepository vaultRepository;


	@Override
	public List<Vault> findAll() {
		 return vaultRepository.findAll();
	}

	@Override
	public Optional<Vault> findById(int id) {
		 return vaultRepository.findById(id);
	}

	@Override
	public Vault create(Vault vault) {
		return vaultRepository.save(vault);
	}

	@Override
	public Vault update(int id, Vault vaultDetails) {
	      Vault vault = vaultRepository.findById(id).orElseThrow(() -> new RuntimeException("Vault not found"));
	        vault.setName(vaultDetails.getName());
	        vault.setStatus(vaultDetails.getStatus());
	        return vaultRepository.save(vault);
	}

	@Override
	public void deleteById(int id) {
		vaultRepository.deleteById(id);
		
	}
}
