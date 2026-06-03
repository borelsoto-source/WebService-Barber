package com.barber.agenda_barber.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.barber.agenda_barber.enums.Speciality;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_barber")
public class Barber implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer speciality;
	
	@JsonIgnore
	@OneToMany(mappedBy = "barber")
	private Set<Scheduling> schedulings = new HashSet<>();
	
	@ManyToMany
    @JoinTable(name = "tb_barber_service", joinColumns = @JoinColumn(name = "barber_id"),inverseJoinColumns = @JoinColumn(name = "service_id"))
	private Set<BarberServ> services = new HashSet<>();
	
	
	public Barber() {
	}

	public Barber(Long id, String name, Speciality speciality) {
		super();
		this.id = id;
		this.name = name;
		setSpeciality(speciality);
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

	public Speciality getSpeciality() {
		return Speciality.valueOf(speciality);
	}
	//USANDO O METEDO valueOf DO ENUM PARA PASSAR O OrderStatus QUE AQUI NESSA CLASSE E DO TIPO INTEGER

	public void setSpeciality(Speciality speciality) {
		if(speciality != null) {
			this.speciality = speciality.getCode();
		}	
	}

	@JsonIgnore
	public Set<Scheduling> getSchedulings() {
		return schedulings;
	}
	
	public Set<BarberServ> getServices() {
		return services;
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
		Barber other = (Barber) obj;
		return Objects.equals(id, other.id);
	}
	
}
