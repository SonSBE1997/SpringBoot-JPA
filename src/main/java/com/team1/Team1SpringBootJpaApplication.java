package com.team1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Team1SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team1SpringBootJpaApplication.class, args);
	}

}

