package com.springboot.expensetracker;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseTrackerApp {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExpenseTrackerApp.class, args);
	}
	
	@Bean
    public ModelMapper modelMapper() {
    	return new ModelMapper();
    }
}
