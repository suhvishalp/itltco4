package com.demo;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class CachingDemoApplicationTests {
	
	@Autowired
	private EmployeeRespository empRepo;
	
	@Autowired
	private EntityManager entityManager;

	@Test
	void contextLoads() {
	}
	
	@Test
	@Transactional
	public void testCacheLevel1() {
		
	    Session session =  	entityManager.unwrap(Session.class);
		
		Optional<Employee> obj1 =  empRepo.findById(1);
		empRepo.findById(1);
		
		Employee emp = null;
		if(obj1.isPresent()) {
			emp = obj1.get();
			session.evict(emp);
		}
	   
	    empRepo.findById(1);
	    empRepo.findById(1);
	    empRepo.findById(1);
	    empRepo.findById(1);
		
	}
	
//	@Test
//	public void testCacheLevel2() {
//		
//		Session session =  	entityManager.unwrap(Session.class);
//		
//		Optional<Employee> obj1 =  empRepo.findById(1);
//		
//		empRepo.findById(1);
//		
//		Employee emp = null;
//		if(obj1.isPresent()) {
//			emp = obj1.get();
//			session.evict(emp);
//		}
//		
//		empRepo.findById(1);
//		empRepo.findById(1);
//		empRepo.findById(1);
//	}
	
	

}
