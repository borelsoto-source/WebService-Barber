package com.barber.agenda_barber.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.barber.agenda_barber.entities.Client;
import com.barber.agenda_barber.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	public ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Joao", "joao@email.com", "1199999999");
		Client c2 = new Client(null, "Maria", "Maria@email.com", "1399999999");
		clientRepository.saveAll(Arrays.asList(c1 , c2));
	}
		
}
