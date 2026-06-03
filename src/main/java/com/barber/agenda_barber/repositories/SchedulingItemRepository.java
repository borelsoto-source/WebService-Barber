package com.barber.agenda_barber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber.agenda_barber.entities.SchedulingItem;
import com.barber.agenda_barber.entities.pk.SchedulingItemPk;

public interface SchedulingItemRepository extends JpaRepository<SchedulingItem, SchedulingItemPk>{

}
