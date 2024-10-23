package com.join.tecnologia.case_join;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CaseJoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseJoinApplication.class, args);
	}

}