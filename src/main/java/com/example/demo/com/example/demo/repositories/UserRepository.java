package com.example.demo.com.example.demo.repositories;

import com.example.demo.com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByLogin(String login);

}
