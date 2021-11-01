package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringDataJpaDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemo1Application.class, args);
	}

}
