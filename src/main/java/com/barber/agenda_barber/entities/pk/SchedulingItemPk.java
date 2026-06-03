package com.barber.agenda_barber.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.barber.agenda_barber.entities.BarberServ;
import com.barber.agenda_barber.entities.Scheduling;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class SchedulingItemPk implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "scheduling_id")
	private Scheduling scheduling;
	
	@ManyToOne
	@JoinColumn(name = "barberServ_id")
	private BarberServ barberServ;

	public Scheduling getScheduling() {
		return scheduling;
	}

	public void setScheduling(Scheduling scheduling) {
		this.scheduling = scheduling;
	}

	public BarberServ getBarberServ() {
		return barberServ;
	}

	public void setBarberServ(BarberServ barberServ) {
		this.barberServ = barberServ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(barberServ, scheduling);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchedulingItemPk other = (SchedulingItemPk) obj;
		return Objects.equals(barberServ, other.barberServ) && Objects.equals(scheduling, other.scheduling);
	}
	
	
	
}
