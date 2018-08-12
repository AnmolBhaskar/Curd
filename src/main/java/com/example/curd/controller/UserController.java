package com.example.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.curd.beans.Users;
import com.example.curd.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public List<Users> getTopics() {
		return userService.getUsers();
	}

	@RequestMapping("/user/{id}")
	public Users getUsers(@PathVariable String id) {
		return userService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/users")
	public void addUser(@RequestBody Users user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/user")
	public void deleteUser(@RequestBody String id) {
		userService.deleteUser(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/user")
	public void updateUser(@RequestBody Users user) {
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
