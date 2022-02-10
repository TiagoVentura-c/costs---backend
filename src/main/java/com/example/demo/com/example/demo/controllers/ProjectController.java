package com.example.demo.com.example.demo.controllers;

import com.example.demo.com.example.demo.dto.ProjectDto;
import com.example.demo.com.example.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @PostMapping
    public ProjectDto save(@RequestBody ProjectDto projectDto, Principal principal){
        return service.saveProject(projectDto, principal.getName());
    }

    @GetMapping
    public List<ProjectDto> getAll(Principal principal){
        return service.getAll(principal.getName());
    }

    @PutMapping
    public  ProjectDto update(@RequestBody ProjectDto projectDto,  Principal principal){
        return service.saveProject(projectDto, principal.getName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.getOne(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }



}
