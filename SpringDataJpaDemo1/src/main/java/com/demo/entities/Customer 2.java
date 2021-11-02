package com.demo.entities;

import javax.persistence.Entity;

@Entity
public class Customer extends User {
 
	private String address;
	private int custId;
	
	public Customer() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	
	
}
