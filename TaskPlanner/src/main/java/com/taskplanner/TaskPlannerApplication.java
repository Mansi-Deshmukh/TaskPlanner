package com.taskplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TaskPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskPlannerApplication.class, args);
	}

}
