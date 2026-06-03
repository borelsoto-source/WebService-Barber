package com.barber.agenda_barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.barber.agenda_barber.entities.Barber;
import com.barber.agenda_barber.repositories.BarberRepository;
import com.barber.agenda_barber.services.exceptions.DatabaseException;
import com.barber.agenda_barber.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
	
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Barber update(Long id, Barber obj) {
		try {
			Barber entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}
	
	public void updateData(Barber entity, Barber obj) {
		entity.setName(obj.getName());
		entity.setSpeciality(obj.getSpeciality());
	}
}

