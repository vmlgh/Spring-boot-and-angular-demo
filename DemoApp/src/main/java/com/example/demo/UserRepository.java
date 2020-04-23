package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	User findByuserNameAndPwd(String username, String pwd);
	
}