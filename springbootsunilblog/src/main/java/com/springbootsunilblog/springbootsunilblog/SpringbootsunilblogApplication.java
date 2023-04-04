package com.springbootsunilblog.springbootsunilblog;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class SpringbootsunilblogApplication {

    @Bean
    ModelMapper modelMapper() {

        return new ModelMapper();
    }

    

    @Bean
    RestTemplate resttemplate() {

        return new RestTemplate();
    }
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringbootsunilblogApplication.class, args);
	
	
	

	
	
	}
	

}
