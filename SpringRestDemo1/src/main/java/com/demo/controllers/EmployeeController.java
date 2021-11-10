package com.demo.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.entities.Employee;
import com.demo.exceptions.EmployeeNotFoundExpcetion;
import com.demo.exceptions.ErrorMessage;
import com.demo.services.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/api/employees")
	public List<Employee> getAllEmp(){
		return empService.getAllEmp();
	}
	
	@GetMapping("/api/employees/{id}")
	public EntityModel<Employee> getEmp(@PathVariable("id") int id){
		
		Employee e =  empService.getEmp(id);
		if(e == null) {
			throw new EmployeeNotFoundExpcetion("Employee with given id is not found");
		}
		
		//hateoas object structure
		//find the server root path ++ /api/employees 
				//or we can retrieve the link for getAllEmp() handler method 
		//send back this path as a link url along with the response  
				
		EntityModel<Employee> resource = EntityModel.of(e);
		
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEmp());
		
		resource.add(linkTo.withRel("allEmp"));
		
		return resource;
	}
	

	@PostMapping("/api/employees")
	public ResponseEntity<Object> save(@Valid @RequestBody Employee emp) throws ValidationException {
		
//		if(emp.getName() == null)
//			throw new ValidationException("Name is requried");
		
		Employee e =  empService.saveEmp(emp);
		
		URI location =  ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(e.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
//	@ExceptionHandler(ValidationException.class)
//	public ResponseEntity<String> myErrorHandler(ValidationException ex){
//		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//	}
	
	
	
	@PutMapping("/api/employees/{id}")
	public Employee updateEmp(@PathVariable("id") int id, @RequestBody Employee emp) {
		return empService.updateEmp(id, emp);
	}
	
	@DeleteMapping("/api/employees/{id}")
	public Employee removeEmp(@PathVariable("id") int id) {
		return empService.removeEmp(id);
	}
	
	
}
