package com.ecommerce.userauthentication.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.userauthentication.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
	
	

}
