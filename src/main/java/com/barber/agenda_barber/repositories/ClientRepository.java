package com.barber.agenda_barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber.agenda_barber.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
