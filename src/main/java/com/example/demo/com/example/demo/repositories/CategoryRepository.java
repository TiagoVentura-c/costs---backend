package com.example.demo.com.example.demo.repositories;

import com.example.demo.com.example.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
