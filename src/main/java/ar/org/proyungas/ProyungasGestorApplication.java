package ar.org.proyungas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProyungasGestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyungasGestorApplication.class, args);
	}

}
