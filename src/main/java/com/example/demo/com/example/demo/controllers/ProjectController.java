package com.example.demo.com.example.demo.controllers;

import com.example.demo.com.example.demo.dto.ProjectDto;
import com.example.demo.com.example.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/project")
public class ProjectController {
    @Autowired
    private ProjectService service;

    @PostMapping
    public ProjectDto save(@RequestBody ProjectDto projectDto){
        return service.saveProject(projectDto);
    }

    @GetMapping
    public List<ProjectDto> getAll(){
        return service.getAll();
    }

    @PutMapping
    public  ProjectDto update(@RequestBody ProjectDto projectDto){
        return service.saveProject(projectDto);
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
