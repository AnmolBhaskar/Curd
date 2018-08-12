package com.example.curd.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String roleId;
	
	@OneToMany
	@JoinColumns({@JoinColumn (name="resourceId")})
	private List<Resource> resourceId;
	
	@Column(name ="description")
	private String description;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<Resource> getResourceId() {
		return resourceId;
	}

	public void setResourceId(List<Resource> resourceId) {
		this.resourceId = resourceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
}
