package com.example.JavaMailProject.Mailer;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MailerConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(MailerRepository mailerRepository) {
	
		return args -> {
			Mailer Vinay = new Mailer(
					"Vinaybabu",
					"Bibinagar",
					"1835947",
					"Bibinagarvinaybabu@gmail.com",
					"Helloworld"
					
				);
			Mailer Venkat = new Mailer(
							"Venkataprasad",
							"suguram",
							"1835946",
							"bibinagarvinaybabu@gmail.com",
							"Hello Venkat"
							);
			
//			mailerRepository.saveAll(List.of(Vinay,Venkat));
		};
	}
	

}
