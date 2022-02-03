package com.example.demo.com.example.demo.services;

import com.example.demo.com.example.demo.dto.ProjectDto;
import com.example.demo.com.example.demo.dto.ServiceDto;
import com.example.demo.com.example.demo.entities.Project;
import com.example.demo.com.example.demo.repositories.ProjectRepository;
import com.example.demo.com.example.demo.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository repository;
    @Autowired
    private ServiceRepository serviceRepository;

    @Transactional
    public ProjectDto saveProject(ProjectDto dto){
        Project project = new Project(null, dto.getName(), dto.getBudget(), dto.getCategory());

        for (ServiceDto sDto: dto.getServicies()){
            Service service = (Service) serviceRepository.getOne(sDto.getId());
            project.getServicies().add((com.example.demo.com.example.demo.entities.Service) service);
        }
        project = repository.save(project);
        return new ProjectDto(project);
    }


}
