package com.example.curd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curd.beans.Role;
import com.example.curd.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getRoles() {
		List<Role> role = new ArrayList<>();
		roleRepository.findAll().forEach(role::add);
		return role;
	}

	public Role getRole(String id) {
		return roleRepository.findById(id).get();
		
	}

	public void addRole(Role role) {
		roleRepository.save(role);
		
	}

	public void deleteRole(String id) {
		roleRepository.delete(getRole(id));
	}

	public void updateRole(Role role) throws Exception{
		Role oldBean = getRole(role.getRoleId());
		if(null == oldBean) {
			throw new Exception ("No role found");
		} else {
			Role updatedBean = new Role();
			updatedBean.setDescription(oldBean.getDescription());
			updatedBean.setResourceId(oldBean.getResourceId());
			updatedBean.setRoleId(oldBean.getRoleId());
			roleRepository.save(updatedBean);
		}
	}

}
