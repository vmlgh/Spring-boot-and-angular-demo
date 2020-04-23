package com.example.demo;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${password_check_regex}")
	String regex;
	
	private Pattern pattern;
	
	@Autowired
	private UserService userService;
	

//	@RequestMapping("/hello")
//	public String getHello() {
//		return "hello";
//	}
//	
	
	
	@RequestMapping("/user/{username}/{pwd}")
	public ResponseEntity<?> getUser(@PathVariable String username, @PathVariable String pwd) {
		if(userService.findByuserNameAndPwd(username, pwd) != null) {
			return new ResponseEntity<>(userService.findByuserNameAndPwd(username, pwd), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody User user) {
		System.out.println(user.getUserName());
		User user1 = new User();
		user1 = userService.findByuserNameAndPwd(user.getUserName(), user.getPwd());
		pattern = Pattern.compile(regex);
		if(user1 == null) {
			
			if(pattern.matcher(user.getPwd()).matches()) {
				userService.save(user);
				return new ResponseEntity<>(user, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	
}
