package com.example.curd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curd.beans.Users;
import com.example.curd.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<Users> getUsers() {
		List<Users> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public Users getUser(String id) {
		return userRepository.findById(id).get();
		
	}

	public void addUser(Users user) {
		userRepository.save(user);
		
	}

	public void deleteUser(String id) {
		userRepository.delete(getUser(id));
	}

	public void updateUser(Users user) throws Exception{
		Users oldBean = getUser(user.getUserName());
		if(null == oldBean) {
			throw new Exception ("No user found");
		} else {
			Users updatedBean = new Users();
			updatedBean.setLocked(oldBean.isLocked());
			updatedBean.setPassword(oldBean.getPassword());
			updatedBean.setRoleId(oldBean.getRoleId());
			updatedBean.setUserName(oldBean.getUserName());
			userRepository.save(updatedBean);
		}
	}

}
