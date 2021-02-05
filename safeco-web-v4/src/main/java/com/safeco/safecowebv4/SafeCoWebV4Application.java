package com.safeco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

@SpringBootApplication
public class SafeCoWebV4Application {

	public static void main(String[] args) {
		SpringApplication.run(SafeCoWebV4Application.class, args);
	}
	
	@Bean
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}

}
