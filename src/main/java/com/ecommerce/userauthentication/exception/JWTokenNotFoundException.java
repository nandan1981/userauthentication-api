package com.ecommerce.userauthentication.exception;

public class JWTokenNotFoundException extends RuntimeException {
	
	public  JWTokenNotFoundException(String message) {
		super(message);
	}

}
