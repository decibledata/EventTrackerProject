package com.skilldistillery.bunker.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.InventoryLog;
import com.skilldistillery.bunker.repositories.InventoryLogRepository;
import com.skilldistillery.bunker.services.InventoryLogService;

@Service
public class InventoryLogServiceImpl implements InventoryLogService {

	@Autowired
	private InventoryLogRepository inventoryLogRepo;

	@Override
	public List<InventoryLog> findAll() {
		return inventoryLogRepo.findAll();
	}

	@Override
	public InventoryLog findById(int id) {
		Optional<InventoryLog> logOpt = inventoryLogRepo.findById(id);
		return logOpt.orElse(null);
	}

	@Override
	public InventoryLog create(InventoryLog inventoryLog) {
		return inventoryLogRepo.save(inventoryLog);
	}

	@Override
	public boolean deleteById(int id) {
		if (inventoryLogRepo.existsById(id)) {
			inventoryLogRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public InventoryLog update(int id, InventoryLog inventoryLog) {
		Optional<InventoryLog> existingLogOpt = inventoryLogRepo.findById(id);

		if (existingLogOpt.isPresent()) {
			InventoryLog existingLog = existingLogOpt.get();

			if (inventoryLog.getTimestamp() != null) {
				existingLog.setTimestamp(inventoryLog.getTimestamp());
			}
			if (inventoryLog.getNotes() != null) {
				existingLog.setNotes(inventoryLog.getNotes());
			}
			if (inventoryLog.getInventory() != null) {
				existingLog.setInventory(inventoryLog.getInventory());
			}
			if (inventoryLog.getUser() != null) {
				existingLog.setUser(inventoryLog.getUser());
			}

			return inventoryLogRepo.save(existingLog);
		}
		return null;
	}
}
