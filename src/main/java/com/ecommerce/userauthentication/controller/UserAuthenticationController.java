package com.ecommerce.userauthentication.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.userauthentication.model.User;

@RestController
@RequestMapping("/authenticate")
public class UserAuthenticationController {
	
	/*
	 * private String java17Test,newnum = """ "This is a new String"
	 * "which is great" """;
	 */	
	/**
	 * @param userId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/helloworld")
	public String helloworld(){
		System.out.println("In hello world");
		return "Hello World";
		
	}
	
	
	/**
	 * @param userId
	 * @return
	 */
	@PostMapping("/fetchUserDetails/userId")
	public ResponseEntity<User> fetchUserDetails(){
		
		User user = new User();
		user.setName("New User");
		HttpHeaders headers = new HttpHeaders();
		return ResponseEntity.ok().headers(headers).body(user);
		
	}
	
	/**
	 * @param user
	 * @return
	 */
	@PostMapping("/getUserJWT")
	public ResponseEntity<String> getUserJWT(@RequestBody User user){
		
		String strJWT = "SDFZE23ZRE==";
		return ResponseEntity.ok().body(strJWT);
		
		
	}
}
