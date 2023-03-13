package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n01.model.domain")
public class S04T02N01SantasusanaAnnaApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N01SantasusanaAnnaApplication.class, args);
	}

}
