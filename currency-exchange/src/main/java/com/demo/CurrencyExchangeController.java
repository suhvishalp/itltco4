package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;

	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchange(@PathVariable("from") String from, @PathVariable("to") String to) {
		
		//logic to go the db, check the exchange rate 
		
		CurrencyExchange ce =  new CurrencyExchange(111, from, to, 87.00);
		ce.setEnvironment(env.getProperty("local.server.port"));
		
		return ce;
	}
}
