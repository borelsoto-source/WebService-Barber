package com.barber.agenda_barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber.agenda_barber.entities.Scheduling;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long>{

}
