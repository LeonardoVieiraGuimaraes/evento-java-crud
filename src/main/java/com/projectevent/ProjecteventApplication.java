package com.projectevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ProjecteventApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjecteventApplication.class, args);
	}

}
