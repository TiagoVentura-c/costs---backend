package com.example.demo.com.example.demo.dto;

import com.example.demo.com.example.demo.entities.Category;
import com.example.demo.com.example.demo.entities.Project;
import com.example.demo.com.example.demo.entities.Service;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private double budget;
    private Category category;
    private List<ServiceDto> servicies;

    public ProjectDto() {
    }

    public ProjectDto(Long id, String name, double budget, Category category) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.category = category;
    }

    public ProjectDto(Project project) {
        this.id = project.getId();
        this.budget = project.getBudget();
        this.name = project.getName();
        this.category = project.getCategory();

        this.servicies = project.getServicies().stream().
                map(service -> new ServiceDto(service)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ServiceDto> getServicies() {
        return servicies;
    }

    public void setServicies(List<ServiceDto> servicies) {
        this.servicies = servicies;
    }
}
