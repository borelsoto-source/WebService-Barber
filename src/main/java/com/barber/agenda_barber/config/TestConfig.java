package com.barber.agenda_barber.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.barber.agenda_barber.entities.Barber;
import com.barber.agenda_barber.entities.BarberServ;
import com.barber.agenda_barber.entities.Client;
import com.barber.agenda_barber.entities.Scheduling;
import com.barber.agenda_barber.entities.SchedulingItem;
import com.barber.agenda_barber.enums.SchedulingStatus;
import com.barber.agenda_barber.enums.Speciality;
import com.barber.agenda_barber.repositories.BarberRepository;
import com.barber.agenda_barber.repositories.BarberServRepository;
import com.barber.agenda_barber.repositories.ClientRepository;
import com.barber.agenda_barber.repositories.SchedulingItemRepository;
import com.barber.agenda_barber.repositories.SchedulingRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	public ClientRepository clientRepository;
	
	@Autowired
	public BarberRepository barberRepository;
	
	@Autowired
	public SchedulingRepository schedulingRepository;
	
	@Autowired
	public BarberServRepository barberServRepository;
	
	@Autowired
	public SchedulingItemRepository schedulingItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		BarberServ serv1 = new BarberServ(null, "Corte", 45.00, 30);
		BarberServ serv2 = new BarberServ(null, "Barba", 20.00, 15);
		BarberServ serv3 = new BarberServ(null, "Sombrancelha", 10.00, 5);
		
		barberServRepository.saveAll(Arrays.asList(serv1, serv2, serv3));
		
		Client c1 = new Client(null, "Joao", "joao@email.com", "1199999999");
		Client c2 = new Client(null, "Maria", "Maria@email.com", "1399999999");
		
		Barber b1 = new Barber(null, "Mario", Speciality.BARBA);
		Barber b2 = new Barber(null, "Jose", Speciality.DEGRADE);
		
		clientRepository.saveAll(Arrays.asList(c1 , c2));
		barberRepository.saveAll(Arrays.asList(b1, b2));
		
		b1.getServices().addAll(Arrays.asList(serv1, serv2));
		b2.getServices().addAll(Arrays.asList(serv1, serv3));
		barberRepository.saveAll(Arrays.asList(b1, b2));
		
		Scheduling s1 = new Scheduling(null, Instant.now(), SchedulingStatus.AGENDADO, c1, b2, 45.00);
		Scheduling s2 = new Scheduling(null, Instant.now(), SchedulingStatus.CONCLUIDO, c1, b1, 20.00);
		Scheduling s3 = new Scheduling(null, Instant.now(), SchedulingStatus.AGENDADO, c2, b2, 45.00);
		schedulingRepository.saveAll(Arrays.asList(s1,s2,s3));

		SchedulingItem si1 = new SchedulingItem(s1, serv1, serv1.getPrice());
		SchedulingItem si2 = new SchedulingItem(s2, serv2, serv2.getPrice());
		SchedulingItem si3 = new SchedulingItem(s3, serv3, serv3.getPrice());
		schedulingItemRepository.saveAll(Arrays.asList(si1, si2, si3));
	}
		
}
