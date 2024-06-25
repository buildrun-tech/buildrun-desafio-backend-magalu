package tech.buildrun.magalu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MagaluApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagaluApplication.class, args);
	}

}
