package com.ecommerce.userauthentication.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.userauthentication.exception.JWTokenNotFoundException;
import com.ecommerce.userauthentication.model.User;

@TestInstance(Lifecycle.PER_CLASS)
class UserAuthenticationControllerTest {

	private UserAuthenticationController control;
	private ResponseEntity<String> token;
	private User user;

	@BeforeEach
	final void setup() {
		control = new UserAuthenticationController();
		user = new User();
	}

	/*
	 * @Test final void testFetchUserDetails() { fail("Not yet implemented"); //
	 * TODO }
	 */

	@Test
	final void testGetUserToken() {
		
		token = new ResponseEntity(HttpStatus.ACCEPTED).ok().body("SDFZE23ZRE==");
		
		ResponseEntity<String> tempEntity;
		tempEntity = control.getUserJWT(user);
		assertEquals(tempEntity,token);
		
		user = null;
		
		Throwable exceptionJWT = assertThrows(JWTokenNotFoundException.class,
	            ()->{control.getUserJWT(user);} );
		
		
	}

}
