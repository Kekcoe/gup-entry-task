package com.kekcoe.calculationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class CalculationServiceApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CalculationServiceApplication.class, args);
		Environment env = context.getEnvironment();
		String[] activeProfiles = env.getActiveProfiles();
		log.info("Active profiles: " + Arrays.toString(activeProfiles));
	}

}
