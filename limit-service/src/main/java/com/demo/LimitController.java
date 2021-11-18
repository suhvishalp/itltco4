package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {
	
	@Autowired
	private Configuration configuration;

	
	@GetMapping("/limits")
	public Limits limits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}
}
