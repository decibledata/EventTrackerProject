package com.skilldistillery.bunker.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.Dweller;
import com.skilldistillery.bunker.entities.Vault;
import com.skilldistillery.bunker.repositories.DwellerRepository;
import com.skilldistillery.bunker.repositories.VaultRepository;
import com.skilldistillery.bunker.services.DwellerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DwellerServiceImpl implements DwellerService {

	@Autowired
    private DwellerRepository dwellerRepository;
	
	@Autowired
	private VaultRepository vaultRepo;

    @Override
    public List<Dweller> findAll() {
        return dwellerRepository.findAll();
    }

	@Override
	public Dweller findById(int id) {
		Optional<Dweller> dweller = dwellerRepository.findById(id);
		return dweller.orElse(null);
	}

	public Dweller create(Dweller dweller) {
	    if (dweller.getVault() == null || dweller.getVault().getId() == 0) {
	        throw new IllegalArgumentException("Vault ID cannot be null or zero");
	    }

	    Optional<Vault> vaultOpt = vaultRepo.findById(dweller.getVault().getId());
	    if (vaultOpt.isPresent()) {
	        dweller.setVault(vaultOpt.get());
	        return dwellerRepository.save(dweller);
	    } else {
	        throw new RuntimeException("Vault not found");
	    }
	}

	@Override
	public Dweller update(int id, Dweller dwellerDetails) {
		if (dwellerRepository.existsById(id)) {
			dwellerDetails.setId(id);
			return dwellerRepository.save(dwellerDetails);
			}
		return null;
	}

	@Override
	public void deleteById(int id) {
		dwellerRepository.deleteById(id);
		
	}

	@Override
	public List<Dweller> findByVaultId(int vaultId) {
	return dwellerRepository.findByVaultId(vaultId);
	}
    
    

}