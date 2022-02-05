package com.supercure.utility;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class UserNotFoundException extends RuntimeException {

	private String msg;
	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	
	
	
	
	
}
