package com.example.demo.com.example.demo.services;

import com.example.demo.com.example.demo.dto.ProjectDto;
import com.example.demo.com.example.demo.dto.ServiceDto;
import com.example.demo.com.example.demo.entities.Project;
import com.example.demo.com.example.demo.repositories.ProjectRepository;
import com.example.demo.com.example.demo.repositories.ServiceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository repository;
    @Autowired
    private ServiceRepository serviceRepository;

    @Transactional
    public ProjectDto saveProject(ProjectDto dto){
        Project project = new Project(dto.getId(), dto.getName(), dto.getBudget(), dto.getCategory());
        project = repository.save(project);

        if(dto.getServices() != null)
        for (ServiceDto sDto: dto.getServices()){
            com.example.demo.com.example.demo.entities.Service service =
                    new com.example.demo.com.example.demo.entities.Service
                            (null, sDto.getName(), sDto.getDescription(), sDto.getCost(), project.getId());
             project.getServices().add(serviceRepository.save(service));
        }
        return new ProjectDto(repository.getById(project.getId()));
    }

    @Transactional
    public ProjectDto addService(ProjectDto dto){
        Project project = new Project();
        project = repository.getById(dto.getId());

        for (ServiceDto sDto: dto.getServices()){
            com.example.demo.com.example.demo.entities.Service service =
                    new com.example.demo.com.example.demo.entities.Service
                            (null, sDto.getName(), sDto.getDescription(), sDto.getCost(), project.getId());
            serviceRepository.save(service);
        }
        return new ProjectDto(project);
    }

    @Transactional
    public List<ProjectDto> getAll(){
        List<Project> list = repository.findAll();
        List<ProjectDto> listDto = new ArrayList<>();
        for(Project p: list)
            listDto.add(new ProjectDto(p));
        return listDto;
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public ProjectDto getOne(Long id) {
        Project project = repository.getById(id);
        ProjectDto projectDto = new ProjectDto(project);
        return  projectDto;

    }

    @Transactional
    public ProjectDto updateProject(ProjectDto dtoSource){
        Project project = repository.getById(dtoSource.getId());
        ProjectDto dtoTarget = new ProjectDto(project);

        BeanUtils.copyProperties(dtoSource, dtoTarget);
/*
            for (ServiceDto sDto: dtoSource.getServices()){
                com.example.demo.com.example.demo.entities.Service service =
                        new com.example.demo.com.example.demo.entities.Service
                                (null, sDto.getName(), sDto.getDescription(), sDto.getCost(), project.getId());
                project.getServices().add(serviceRepository.save(service));
            }*/
        return new ProjectDto(repository.getById(project.getId()));
    }
}
