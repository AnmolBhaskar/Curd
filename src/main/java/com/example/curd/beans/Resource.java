package com.example.curd.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resource {

	@Id
	private String resourceId;
	
	@Column
	private String description;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
