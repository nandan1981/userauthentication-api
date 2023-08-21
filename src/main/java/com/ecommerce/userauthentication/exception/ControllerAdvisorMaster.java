package com.ecommerce.userauthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisorMaster extends ResponseEntityExceptionHandler {

	@ExceptionHandler(JWTokenNotFoundException.class)
	public ResponseEntity<String> handleJWTException(JWTokenNotFoundException jex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jex.getMessage());
	}

}
