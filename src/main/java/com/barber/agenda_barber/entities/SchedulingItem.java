package com.barber.agenda_barber.entities;

import java.io.Serializable;
import java.util.Objects;

import com.barber.agenda_barber.entities.pk.SchedulingItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_scheduling_item")
public class SchedulingItem implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SchedulingItemPk id = new SchedulingItemPk();
	
	private Double price;
	
	public SchedulingItem() {
	}

	public SchedulingItem(Scheduling scheduling, BarberServ barberServ, Double price) {
		super();
		id.setScheduling(scheduling);
		id.setBarberServ(barberServ);
		this.price = price;
	}

	@JsonIgnore
	public Scheduling getScheduling() {
		return id.getScheduling();
	}
	
	@JsonIgnore
	public BarberServ getBarberServ() {
		return id.getBarberServ();
	}
	
	public SchedulingItemPk getId() {
		return id;
	}

	public Double getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchedulingItem other = (SchedulingItem) obj;
		return Objects.equals(id, other.id);
	}
	
}

