package com.bourg.receiptweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.bourg.receiptweb.domain")
public class ReceiptwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceiptwebApplication.class, args);
	}

}
