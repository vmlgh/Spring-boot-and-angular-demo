package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User findByuserNameAndPwd(String username, String pwd) {
		return userRepository.findByuserNameAndPwd(username, pwd);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
}
