package com.ecommerce.userauthentication.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.userauthentication.model.User;
import com.ecommerce.userauthentication.model.UserDetails;

public interface UserRepository extends CrudRepository<UserDetails,Long> {
	
	

}
