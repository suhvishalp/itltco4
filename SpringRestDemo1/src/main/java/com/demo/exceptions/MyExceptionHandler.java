package com.demo.exceptions;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {

	
	@ResponseBody
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> myErrorHandler(ValidationException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundExpcetion.class)
	public ErrorMessage notFoundExpcetion(EmployeeNotFoundExpcetion ex){
		return new ErrorMessage(ex.getMessage(), "404");
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FieldErrorMessage> invalidEmpException(MethodArgumentNotValidException ex) {
		
		List<FieldError> errors =  ex.getFieldErrors();
	
		List<FieldErrorMessage> errorlist = new ArrayList<>();
	
		for(FieldError err : errors) {
			FieldErrorMessage e = new FieldErrorMessage();
			e.setField(err.getField());
			e.setMessage(err.getDefaultMessage());
			errorlist.add(e);
		}
		
		
		return errorlist;
		
	}


}
