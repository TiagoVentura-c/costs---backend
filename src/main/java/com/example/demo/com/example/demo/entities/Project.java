package com.example.demo.com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tb_project")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private double budget;

	@JoinColumn(name = "id_category")
	@ManyToOne
	private Category category;

	@OneToMany()
	private List<Service> servicies;

	public Project(){
	}

	public Project(Long id, String name, double budget, Category category) {
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.category = category;
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

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Service> getServicies() {
		return servicies;
	}

	public void setServicies(List<Service> servicies) {
		this.servicies = servicies;
	}
}
