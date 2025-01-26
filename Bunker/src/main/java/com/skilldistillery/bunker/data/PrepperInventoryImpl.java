package com.skilldistillery.bunker.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.PrepperInventory;
import com.skilldistillery.bunker.repositories.PrepperInventoryRepository;
import com.skilldistillery.bunker.services.PrepperInventoryService;

@Service
public class PrepperInventoryImpl implements PrepperInventoryService {

	@Autowired
	private PrepperInventoryRepository prepInv;
	
	@Override
	public List<PrepperInventory> findAll() {
		return prepInv.findAll();
	}

	@Override
	public PrepperInventory findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrepperInventory create(PrepperInventory newPrep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrepperInventory update(int prepId, PrepperInventory prep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int prepId) {
		// TODO Auto-generated method stub
		return false;
	}

}
