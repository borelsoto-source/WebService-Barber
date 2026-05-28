package com.barber.agenda_barber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barber.agenda_barber.entities.Client;
import com.barber.agenda_barber.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException());
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
}

