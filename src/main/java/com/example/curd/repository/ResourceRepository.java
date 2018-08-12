package com.example.curd.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.curd.beans.Resource;

public interface ResourceRepository extends CrudRepository<Resource, String>{

}
