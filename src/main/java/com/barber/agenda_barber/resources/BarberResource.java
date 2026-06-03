package com.barber.agenda_barber.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.barber.agenda_barber.entities.Barber;
import com.barber.agenda_barber.services.BarberService;

@RestController
@RequestMapping(value = "/barbers")
public class BarberResource {
	
	@Autowired
	public BarberService service;
	
	@GetMapping	
	public ResponseEntity <List<Barber>> findAll(){
		List<Barber> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity <Barber> findById(@PathVariable Long id) {
		Barber obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity <Barber> insert(@RequestBody Barber obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Barber> update(@PathVariable Long id, @RequestBody Barber obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
