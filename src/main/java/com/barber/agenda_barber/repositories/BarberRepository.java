package com.barber.agenda_barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber.agenda_barber.entities.Barber;

public interface BarberRepository extends JpaRepository<Barber, Long>{

}
