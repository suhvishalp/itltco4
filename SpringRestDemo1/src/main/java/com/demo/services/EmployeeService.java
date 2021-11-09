package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.Employee;
import com.demo.repositories.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public Employee saveEmp(Employee emp) {
		return empRepo.save(emp);
	}
	
	public List<Employee> getAllEmp(){
		return empRepo.findAll();
	}

	public Employee getEmp(int id) {

		Optional<Employee> optEmp = empRepo.findById(id);

		if (optEmp.isPresent()) {
			Employee e = optEmp.get();

			return e;
		}

		return null;
	}

	public Employee removeEmp(int id) {

		Optional<Employee> optEmp = empRepo.findById(id);

		if (optEmp.isPresent()) {
			Employee e = optEmp.get();
			empRepo.delete(e);
			return e;
		}

		return null;
	}

	public Employee updateEmp(int id, Employee emp) {

		Optional<Employee> optEmp = empRepo.findById(id);

		if (optEmp.isPresent()) {
			Employee e = optEmp.get();
			e.setCity(emp.getCity());
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			empRepo.save(e);
			return e;
		}

		return null;
	}

}
