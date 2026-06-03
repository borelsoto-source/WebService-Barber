package com.barber.agenda_barber.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.barber.agenda_barber.entities.BarberServ;
import com.barber.agenda_barber.services.BarberServService;

@RestController
@RequestMapping(value = "/barberservs")
public class BarberServResource {
	
	@Autowired
	public BarberServService service;
	
	@GetMapping	
	public ResponseEntity <List<BarberServ>> findAll(){
		List<BarberServ> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <BarberServ> findById(@PathVariable Long id) {
		BarberServ obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity <BarberServ> insert(@RequestBody BarberServ obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
