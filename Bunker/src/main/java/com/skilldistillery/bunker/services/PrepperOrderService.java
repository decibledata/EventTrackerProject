package com.skilldistillery.bunker.services;

import java.util.List;

import com.skilldistillery.bunker.entities.PrepperOrder;

public interface PrepperOrderService {

	List<PrepperOrder> findAll();

	PrepperOrder create(PrepperOrder order);

	PrepperOrder update(int id, PrepperOrder order);

	boolean deleteById(int id);

}
