package com.dws.band;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BandApplication {

	public static void main(String[] args) {
		SpringApplication.run(BandApplication.class, args);
	}

}
