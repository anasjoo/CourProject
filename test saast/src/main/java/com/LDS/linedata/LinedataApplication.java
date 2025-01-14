package com.LDS.linedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages = {"com.LDS.linedata.user", "com.LDS.linedata.cour"})
@RestController
public class LinedataApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinedataApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "helloo";
	}
}
