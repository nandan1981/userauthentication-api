package com.ecommerce.userauthentication.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.userauthentication.exception.JWTokenNotFoundException;
import com.ecommerce.userauthentication.model.User;

/**
 * 
 * @startuml
 * Alice -> Bob : Hello
 * Bob -> Alice : Hello
 * @enduml
 */

@RestController
@RequestMapping("/v1/authenticate")
public class UserAuthenticationController {
	
	 private static final Logger logger = LogManager.getLogger(UserAuthenticationController.class);

	@Autowired
	public RestTemplate restCall;
	/**
	 * @param userId
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@GetMapping("/helloworld")
	public String helloworld() {
		logger.info("In hello world");
		if(true)
			throw new JWTokenNotFoundException("Token not found");
		return "Hello World";

	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/callPricingService")
	public String callPricingService() {
		ResponseEntity<String> response = restCall.getForEntity("http://localhost:8035/v1/pricing/echo",String.class);
		return "Response from Pricing service :== "+response.getBody();
	}

	/**
	 * @param userId
	 * @return
	 */
	@PostMapping("/fetchUserDetails/userId")
	public ResponseEntity<User> fetchUserDetails() {
		var user = new User();
		user.setName("New User");
		HttpHeaders headers = new HttpHeaders();
		return ResponseEntity.ok().headers(headers).body(user);
	}

	/**
	 * @param user
	 * @return
	 */
	@PostMapping("/getUserJWT")
	public ResponseEntity<String> getUserJWT(@RequestBody User user) {
		
		if(user == null)
			throw new JWTokenNotFoundException("No token");
		
		var strJWT = "SDFZE23ZRE==";
		return ResponseEntity.ok().body(strJWT);
	}
}
