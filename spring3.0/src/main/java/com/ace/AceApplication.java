package com.ace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@EntityScan(basePackages = { "com.ace" })
@EnableJpaRepositories(basePackages = { "com.ace" })
@SpringBootApplication(scanBasePackages = { "com.ace" })
public class AceApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(AceApplication.class, args);
			System.out.println("Server startup done");
		} catch (Exception e) {
			log.error("server support error", e);
		}
	}

}
