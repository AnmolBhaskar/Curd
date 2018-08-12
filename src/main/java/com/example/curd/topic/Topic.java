package com.example.curd.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public  class Topic {
	
	@Id
	private String name;
	private String id;
	private String description;
	
	public Topic() {
		
	}
	
	public Topic(String name, String id, String description) {
		this.name = name;
		this.id = id;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Topics [name=" + name + ", id=" + id + ", description=" + description + "]";
	}
	
}
