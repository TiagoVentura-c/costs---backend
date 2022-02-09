package com.example.demo.com.example.demo.controllers;

import com.example.demo.com.example.demo.entities.User;
import com.example.demo.com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/api/user")
    public String get(){
        return "Acessou";
    }

    @PostMapping("/signin")
    public ResponseEntity<User> salvar(@RequestBody User usuario) {
        if(!repository.findByLogin(usuario.getLogin()).isEmpty())
            return ResponseEntity.badRequest().build();
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(repository.save(usuario));
    }

}
