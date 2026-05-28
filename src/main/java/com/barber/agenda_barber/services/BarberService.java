package com.barber.agenda_barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.agenda_barber.entities.Barber;
import com.barber.agenda_barber.repositories.BarberRepository;

@Service
public class BarberService {

	@Autowired
	private BarberRepository repository;
	
	public List<Barber> findAll(){
		return repository.findAll();
	}
	
	public Barber findById(Long id) {
		Optional<Barber> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException());
	}
	
	public Barber insert(Barber obj) {
		return repository.save(obj);
	}
}

