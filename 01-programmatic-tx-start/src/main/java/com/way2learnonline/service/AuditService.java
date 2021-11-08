package com.way2learnonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class AuditService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	PlatformTransactionManager txManager;
	
	
	public void writeAuditLog(String message){
		
		// start the transaction
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus status = txManager.getTransaction(definition);

				System.out.println("in writeAuditLog() method : status " + status.isNewTransaction()); // true
			
		try {
			String query="insert into auditlogs(logmessage) values(?) ";			
			jdbcTemplate.update(query,message);
			txManager.commit(status);
		}catch (Exception e) {
			// TODO: handle exception
			txManager.rollback(status);
		}
			
		
	}

}
