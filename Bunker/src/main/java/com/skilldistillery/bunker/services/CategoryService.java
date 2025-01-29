package com.skilldistillery.bunker.services;

import java.util.List;

import com.skilldistillery.bunker.entities.Category;

public interface CategoryService {

	List<Category> findAll();

	Category findById(int id);

	Category create(Category inv);

	Category update(int id, Category inventory);

	boolean deleteById(int id);

}