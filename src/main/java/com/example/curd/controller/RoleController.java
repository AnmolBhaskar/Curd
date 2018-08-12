package com.example.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.curd.beans.Role;
import com.example.curd.service.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleservice;

	@RequestMapping("/roles")
	public List<Role> getRole() {
		return roleservice.getRoles();
	}

	@RequestMapping("/role/{id}")
	public Role getRole(@PathVariable String id) {
		return roleservice.getRole(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/roles")
	public void addRole(@RequestBody Role role) {
		roleservice.addRole(role);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/roles")
	public void deleteRole(@RequestBody String id) {
		roleservice.deleteRole(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/roles")
	public void updateRole(@RequestBody Role role) {
		try {
			roleservice.updateRole(role);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}



}
