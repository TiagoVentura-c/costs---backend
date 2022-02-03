package com.example.demo.com.example.demo.repositories;

import com.example.demo.com.example.demo.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
