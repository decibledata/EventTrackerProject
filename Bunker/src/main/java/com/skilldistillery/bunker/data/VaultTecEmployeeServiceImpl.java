package com.skilldistillery.bunker.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.VaultTecEmployee;
import com.skilldistillery.bunker.repositories.VaultTecEmployeeRepository;
import com.skilldistillery.bunker.services.VaultTecEmployeeService;

@Service
public class VaultTecEmployeeServiceImpl implements VaultTecEmployeeService {

	@Autowired
    private VaultTecEmployeeRepository vaultTecEmployeeRepository;

	@Override
	public List<VaultTecEmployee> findAll() {
		return vaultTecEmployeeRepository.findAll();
	}

	@Override
	public Optional<VaultTecEmployee> findById(int id) {
		return vaultTecEmployeeRepository.findById(id);
	}

	@Override
	public VaultTecEmployee create(VaultTecEmployee employee) {
		   return vaultTecEmployeeRepository.save(employee);
	}

	@Override
	public VaultTecEmployee update(int id, VaultTecEmployee employeeDetails) {
		   VaultTecEmployee employee = vaultTecEmployeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	        employee.setName(employeeDetails.getName());
	        employee.setRole(employeeDetails.getRole());
	        return vaultTecEmployeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		vaultTecEmployeeRepository.deleteById(id);
		
	}
}