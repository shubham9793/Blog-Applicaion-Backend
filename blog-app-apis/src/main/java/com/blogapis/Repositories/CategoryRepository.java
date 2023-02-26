package com.blogapis.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapis.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
