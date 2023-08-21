package com.ecommerce.userauthentication.exception;

public class JWTokenNotFoundException extends RuntimeException {
	
	public  JWTokenNotFoundException() {
		super("Token not found");
	}

}
