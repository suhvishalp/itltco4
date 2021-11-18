package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExProxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/qty/{qty}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable("from") String from, 
			@PathVariable("to") String to, 
			@PathVariable("qty") int qty ) {
		
		//make a http get request to currency-exchange service and get the rate
//		RestTemplate restTemplate = new RestTemplate();
//		
//		String url = "http://localhost:8083/currency-exchange/from/"+from+"/to/"+to;
//		
//		CurrencyExchange ce =  restTemplate.getForObject(url, CurrencyExchange.class);
//		
//		double rate = ce.getExchangeValue();
//		
//		double total = qty * rate;
		
		CurrencyExchange ce = currencyExProxy.retrieveExchange(from, to);

		double rate = ce.getExchangeValue();		
		double total = qty * rate;
		
		CurrencyConversion cc =  new CurrencyConversion(1, from, to, rate, qty, total);
		
		return cc;
		
	}
}
