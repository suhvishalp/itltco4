package com.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmployeeNotFoundExpcetion  extends RuntimeException {

	public EmployeeNotFoundExpcetion(String msg) {
		super(msg);
	}
	
}
