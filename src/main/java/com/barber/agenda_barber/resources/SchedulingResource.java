package com.barber.agenda_barber.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.agenda_barber.entities.Scheduling;
import com.barber.agenda_barber.services.SchedulingService;

@RestController
@RequestMapping(value = "/schedulings")
public class SchedulingResource {
	
	@Autowired
	public SchedulingService service;
	
	@GetMapping	
	public ResponseEntity <List<Scheduling>> findAll(){
		List<Scheduling> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <Scheduling> findById(@PathVariable Long id) {
		Scheduling obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
