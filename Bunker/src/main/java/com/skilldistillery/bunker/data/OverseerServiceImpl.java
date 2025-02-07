package com.skilldistillery.bunker.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.Overseer;
import com.skilldistillery.bunker.repositories.OverseerRepository;
import com.skilldistillery.bunker.services.OverseerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OverseerServiceImpl implements OverseerService {
	
	@Autowired
	private OverseerRepository overseerRepo;

	@Override
	public List<Overseer> findAll() {
		return overseerRepo.findAll();
	}

	@Override
	public Overseer findById(int id) {
		Optional<Overseer> overItem = overseerRepo.findById(id);
		return overItem.orElse(null);
	}

	@Override
	public Overseer create(Overseer overseer) {
		return overseerRepo.save(overseer);
	}

	@Override
	public Overseer update(int id, Overseer updatedOverseer) {
		if (overseerRepo.existsById(id)) {
			updatedOverseer.setId(id);
			return overseerRepo.save(updatedOverseer);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		overseerRepo.deleteById(id);
		
	}

}
