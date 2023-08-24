package com.ecommerce.userauthentication.repository;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.ecommerce.userauthentication.model.UserDetails;

public class UserRepositoryImpl {
	
	private UserRepository repository;
	
	public UserRepositoryImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	
	public ResponseEntity<Optional<UserDetails>> getUserData(Long id){
		
		return ResponseEntity.ok().body(repository.findById(id).or(null));
		
		
	}
	
	
	

}
