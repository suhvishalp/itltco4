package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

		//	  long count()
		//    void	delete(T entity)
		//    void	deleteAll()
		//    void	deleteById(ID id)
		//    Iterable<T>	findAll()
		//    Optional<T>	findById(ID id)
		//    |<S extends T> S	save(S entity)
		//	<S extends T>List<S>	findAll(	<S> example)
	
//		@Query(value= "SELECT e FROM Employee e where e.salary>=:sal")
//		List<Employee> getAllEmployees(@Param("sal") double salary);
	
			@Query(value = "SELECT * FROM Employee e where salary>=:sal", nativeQuery = true)
			List<Employee> getAllEmployees(@Param("sal") double salary);
			
			
			//named query example
			List<Employee> getAllEmpsByCity(String city);
			
			
			//Query Generation Methods 
			
			List<Employee> findAllByCity(String city);
			
			List<Employee> findAllByCityAndSalaryGreaterThan(String city, double salary);
}

// spring data jpa offers a "proxy instance" of this interface 
