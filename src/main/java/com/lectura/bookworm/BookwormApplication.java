package com.lectura.bookworm;

import com.lectura.bookworm.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookwormApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookwormApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Bookworm Application");
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
