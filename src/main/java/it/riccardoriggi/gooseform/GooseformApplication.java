package it.riccardoriggi.gooseform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("it.riccardoriggi.gooseform.entity")
public class GooseformApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(GooseformApplication.class);
		app.setLazyInitialization(true);
		app.run(args);
	}

}
