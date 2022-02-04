package com.example.demo.com.example.demo.controllers;

import com.example.demo.com.example.demo.entities.Category;
import com.example.demo.com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/category")
public class CategoryController {

    @Autowired
    public CategoryRepository repository;

    @PostMapping
    public Category save(@RequestBody Category category){
        return repository.save(category);
    }

}
