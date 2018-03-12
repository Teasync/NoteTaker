package ca.cerul3an.notetaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NotetakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotetakerApplication.class, args);
	}
}
