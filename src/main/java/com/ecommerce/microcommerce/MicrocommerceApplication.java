package com.ecommerce.microcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*composante de 3 annotations : @Configuration , @EnableAutoConfiguration et @ComponentScan
en resumé cela active l'auto-configuration*/

@SpringBootApplication
public class MicrocommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrocommerceApplication.class, args);
	}

}
