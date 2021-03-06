package com.glinboy.jcart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ProblemConfig {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().
				registerModules(new ProblemModule(),
						new ConstraintViolationProblemModule());
	}
}
