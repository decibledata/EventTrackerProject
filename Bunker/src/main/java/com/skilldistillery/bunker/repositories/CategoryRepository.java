package com.skilldistillery.bunker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.bunker.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}