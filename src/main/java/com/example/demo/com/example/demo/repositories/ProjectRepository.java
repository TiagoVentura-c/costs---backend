package com.example.demo.com.example.demo.repositories;

import com.example.demo.com.example.demo.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
