package com.example.hei.TdProg3Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class TdProg3SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdProg3SpringApplication.class, args);
	}

}
