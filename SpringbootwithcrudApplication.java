package com.example.springbootwithcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
//@OpenAPIDefintion(info = @Info(title = "product_api" , version = "0.0.1", description = "product information"))
@SpringBootApplication
public class SpringbootwithcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwithcrudApplication.class, args);
	}

}
