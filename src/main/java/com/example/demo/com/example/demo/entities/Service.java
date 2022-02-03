package com.example.demo.com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_service")
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;
    private String description;
    private double cost;

    public Service(Long id, String name, String description, double cost, Project project) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.project = project;
    }

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
