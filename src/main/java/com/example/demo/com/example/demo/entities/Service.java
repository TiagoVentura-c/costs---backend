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

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;
}
