package com.barber.agenda_barber.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.agenda_barber.entities.Client;
import com.barber.agenda_barber.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	public ClientService service;
	
	@GetMapping	
	public ResponseEntity <List<Client>> findAll(){
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
