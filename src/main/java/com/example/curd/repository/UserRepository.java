package com.example.curd.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.curd.beans.Users;

public interface UserRepository extends CrudRepository<Users, String>{ 

}
