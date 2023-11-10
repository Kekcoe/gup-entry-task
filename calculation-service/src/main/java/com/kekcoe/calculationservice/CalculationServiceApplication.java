package com.kekcoe.calculationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CalculationServiceApplication {

	public static void main(String[] args) {
		log.info("***** CalculationServiceApplication started");
		SpringApplication.run(CalculationServiceApplication.class, args);
	}

}
