package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;


public interface UserRepository extends CrudRepository<User, Integer>{
	
	User findByUserNameAndPwd(String username, String pwd);
	
}
