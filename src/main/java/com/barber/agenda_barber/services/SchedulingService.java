package com.barber.agenda_barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.agenda_barber.entities.Scheduling;
import com.barber.agenda_barber.repositories.SchedulingRepository;

@Service
public class SchedulingService {

	@Autowired
	public SchedulingRepository repository;
	
	public List<Scheduling> findAll(){
		return repository.findAll();
	}
	
	public Scheduling findById(Long id) {
		Optional<Scheduling> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException());
	}
	
	public Scheduling insert(Scheduling obj) {
		return repository.save(obj);
	}
}
