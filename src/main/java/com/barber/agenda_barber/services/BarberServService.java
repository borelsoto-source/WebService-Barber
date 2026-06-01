package com.barber.agenda_barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.agenda_barber.entities.BarberServ;
import com.barber.agenda_barber.repositories.BarberServRepository;

@Service
public class BarberServService {

	@Autowired
	private BarberServRepository repository;
	
	public List<BarberServ> findAll(){
		return repository.findAll();
	}
	
	public BarberServ findById(Long id) {
		Optional<BarberServ> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException());
	}
	
	public BarberServ insert(BarberServ obj) {
		return repository.save(obj);
	}
}

