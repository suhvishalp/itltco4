package com.demo.demo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Address;
import com.demo.entities.Customer;
import com.demo.repositories.AddressRepository;
import com.demo.repositories.CustomerRepository;

@SpringBootTest
class AssociationsDemo1ApplicationTests {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private AddressRepository addRepo;
	
	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void testCustomerCreate() {
//		
//		
//		Customer customer = new Customer();
//		customer.setName("Dinesh");
//		
//		
//		
//		Address add1 = new Address();
//		add1.setCity("Bangalore");
//		add1.setStreet("some Street");
//		
//		
//		
//		Address add2 = new Address();
//		add2.setCity("Chennai");
//		add2.setStreet("OMR Road");
//		
//	
//		customer.addAddress(add1);
//		customer.addAddress(add2);
//		
//		
//		customerRepo.save(customer);
//		
//	}

	
	@Test
	@Transactional
	public void testCustomerRead() {
		
		Optional<Customer> optCustomer = customerRepo.findById(4);
		
		if(optCustomer.isPresent()) {
			Customer cust = optCustomer.get();
			System.out.println(cust.getName());
			
			Set<Address> addressSet = cust.getAddresses();
			System.out.println(addressSet.size());
			
		}
		
	}
	
}





















