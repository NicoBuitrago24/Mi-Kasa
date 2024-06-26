package com.ucentral.MiKasa;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class MiKasaProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MiKasaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
