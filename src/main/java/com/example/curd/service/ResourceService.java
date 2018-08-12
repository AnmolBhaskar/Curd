package com.example.curd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curd.beans.Resource;
import com.example.curd.repository.ResourceRepository;

@Service
public class ResourceService {

	@Autowired
	private ResourceRepository resourceRepository;
	
	public List<Resource> getResources() {
		List<Resource> role = new ArrayList<>();
		resourceRepository.findAll().forEach(role::add);
		return role;
	}

	public Resource getResource(String id) {
		return resourceRepository.findById(id).get();
		
	}

	public void addResource(Resource resource) {
		resourceRepository.save(resource);
		
	}

	public void deleteResource(String id) {
		resourceRepository.delete(getResource(id));
	}

	public void updateResource(Resource resource) throws Exception{
		Resource oldBean = getResource(resource.getResourceId());
		if(null == oldBean) {
			throw new Exception ("No role found");
		} else {
			Resource updatedBean = new Resource();
			updatedBean.setDescription(oldBean.getDescription());
			updatedBean.setResourceId(oldBean.getResourceId());
			resourceRepository.save(updatedBean);
		}
	}



}
