package com.example.demo.com.example.demo.dto;

import com.example.demo.com.example.demo.entities.Service;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ServiceDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String  name;
    private String description;
    private double cost;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long projectId;

    public ServiceDto() {
    }

    public ServiceDto(Service service) {
        this.id = service.getId();
        this.description = service.getDescription();
        this.name = service.getName();
        this.cost = service.getCost();
        this.projectId = service.getIdProject();
    }

    public ServiceDto(Long id, String name, String description, double cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public ServiceDto(Long id, String name, String description, double cost, Long projectId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.projectId = projectId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
