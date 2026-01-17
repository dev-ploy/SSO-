package com.example.demo;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableWebSecurity
public class DemoApplication {
	@GetMapping("/")
	public String home(Principal principal){
		return "Hi "+principal.getName()+" welcome to the application"+principal.getName();

	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
