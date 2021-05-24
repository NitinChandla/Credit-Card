package com.home.nitin.creditcardprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.home.nitin.creditcardprovider.repository"})
@ComponentScan("com.home.nitin")
@EntityScan(basePackages = {"com.home.nitin.creditcardprovider.entity"})
public class CreditCardProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardProviderApplication.class, args);
	}

}
