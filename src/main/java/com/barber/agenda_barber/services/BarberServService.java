package com.barber.agenda_barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.agenda_barber.entities.BarberServ;
import com.barber.agenda_barber.repositories.BarberServRepository;
import com.barber.agenda_barber.services.exceptions.DatabaseException;

import jakarta.persistence.EntityNotFoundException;

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
	
	public BarberServ update(Long id, BarberServ obj) {
		try {
			BarberServ entity = repository.getReferenceById(id);
			updateData(entity,obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public void updateData(BarberServ entity, BarberServ obj) {
		entity.setName(obj.getName());
		entity.setPrice(obj.getPrice());
	}
}

