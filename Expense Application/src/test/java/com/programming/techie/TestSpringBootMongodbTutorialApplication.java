package com.programming.techie;

import org.springframework.boot.SpringApplication;

public class TestSpringBootMongodbTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringBootExpenseApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
