package cl.corona.bbooksize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BbookSizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbookSizeApplication.class, args);
	}

}
