package com.example.demo.com.example.demo.services;

import com.example.demo.com.example.demo.dto.ServiceDto;
import com.example.demo.com.example.demo.entities.Project;
import com.example.demo.com.example.demo.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    /*@Autowired
    private ServiceRepository repository;

    public ServiceDto save(ServiceDto dto){
        Project project = new Project();
        project.setId(dto.getProjectDto().getId());
        com.example.demo.com.example.demo.entities.Service service = new com.example.demo.com.example.demo.entities
                .Service(null, dto.getName(), dto.getDescription(), dto.getCost(), project);

        return new ServiceDto(repository.save(service));
    }*/
}
