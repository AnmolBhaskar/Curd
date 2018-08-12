package com.example.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.curd.beans.Resource;
import com.example.curd.service.ResourceService;

@RestController
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;

	@RequestMapping("/resources")
	public List<Resource> getResources() {
		return resourceService.getResources();
	}

	@RequestMapping("/resource/{id}")
	public Resource getResource(@PathVariable String id) {
		return resourceService.getResource(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/resource")
	public void addTopic(@RequestBody Resource resource) {
		resourceService.addResource(resource);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/resource")
	public void deleteTopic(@RequestBody String id) {
		resourceService.deleteResource(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/resource")
	public void updateResource(@RequestBody Resource resource) {
		try {
			resourceService.updateResource(resource);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}





}
