package com.demo.repositories;

import com.demo.entities.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findAllByCity(String city);

}
