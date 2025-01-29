package com.skilldistillery.bunker.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.bunker.entities.Category;
import com.skilldistillery.bunker.repositories.CategoryRepository;
import com.skilldistillery.bunker.services.CategoryService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	@Override
	public Category findById(int id) {
		Optional<Category> category = categoryRepo.findById(id);
		return category.orElse(null);
	}

	@Override
	public Category create(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category update(int id, Category category) {
		if (categoryRepo.existsById(id)) {
			category.setId(id);
			return categoryRepo.save(category);
		}
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		if (categoryRepo.existsById(id)) {
			categoryRepo.deleteById(id);
			return true;
		}
		return false;
	}
}
