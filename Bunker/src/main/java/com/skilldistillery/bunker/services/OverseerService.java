package com.skilldistillery.bunker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.Overseer;

@Service
public interface OverseerService {

	List<Overseer> findAll();

	Overseer findById(int id);

	Overseer create(Overseer overseer);

	Overseer update(int id, Overseer updatedOverseer);

	void deleteById(int id);

}
