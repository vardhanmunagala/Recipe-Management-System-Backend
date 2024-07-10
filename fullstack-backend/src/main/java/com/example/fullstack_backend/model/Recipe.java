package com.example.fullstack_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private int prep_time_in_mins;
	private int cook_time_in_mins;
	private int total_time_in_mins;
	private int servings;
	private String ingredients;
	private String category;
	private String author;
	private String reference_url;
	
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
	public int getPrep_time_in_mins() {
		return prep_time_in_mins;
	}
	public void setPrep_time_in_mins(int prep_time_in_mins) {
		this.prep_time_in_mins = prep_time_in_mins;
	}
	public int getCook_time_in_mins() {
		return cook_time_in_mins;
	}
	public void setCook_time_in_mins(int cook_time_in_mins) {
		this.cook_time_in_mins = cook_time_in_mins;
	}
	public int getTotal_time_in_mins() {
		return total_time_in_mins;
	}
	public void setTotal_time_in_mins(int total_time_in_mins) {
		this.total_time_in_mins = total_time_in_mins;
	}
	public int getServings() {
		return servings;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getReference_url() {
		return reference_url;
	}
	public void setReference_url(String reference_url) {
		this.reference_url = reference_url;
	}

}
