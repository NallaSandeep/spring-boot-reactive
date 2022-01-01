package com.ftd.springboot.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ftd.springboot.webflux.client.GreetingClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		GreetingClient client = applicationContext.getBean(GreetingClient.class);
		System.out.println(">> Message = " + client.getMessage().block());
	}

}
