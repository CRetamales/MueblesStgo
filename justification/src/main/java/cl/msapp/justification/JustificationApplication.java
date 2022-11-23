package cl.msapp.justification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JustificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustificationApplication.class, args);
	}

}
