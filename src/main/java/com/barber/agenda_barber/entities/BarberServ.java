package com.barber.agenda_barber.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_service")
public class BarberServ implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	private Integer duration;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "services")
	private Set<Barber> barbers = new HashSet<>();
	
	/*
	@ManyToMany(mappedBy = "service")
	private Set<Scheduling> schedulings = new HashSet<>();
	*/
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.barberServ")
	private Set<SchedulingItem> items = new HashSet<>();
	
	public BarberServ() {
	}

	public BarberServ(Long id, String name, Double price, Integer duration) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.duration = duration;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Set<Barber> getBarbers() {
		return barbers;
	}

	@JsonIgnore
	public Set<SchedulingItem> getItems() {
		return items;
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
		BarberServ other = (BarberServ) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
