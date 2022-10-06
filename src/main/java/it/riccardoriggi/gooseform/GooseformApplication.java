package it.riccardoriggi.gooseform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication
@EntityScan("it.riccardoriggi.gooseform.entity")
public class GooseformApplication {

	public static void main(String[] args) {
		SpringApplication.run(GooseformApplication.class, args);
	}

}
