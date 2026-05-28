package com.barber.agenda_barber.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.barber.agenda_barber.enums.SchedulingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_scheduling")
public class Scheduling implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant date;
	private Integer schedulingStatus;
	private Double totalValue;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Barber barber;
	
	public Scheduling() {
	}

	public Scheduling(Long id, Instant date, SchedulingStatus schedulingStatus, Client client, Barber barber, Double totalValue) {
		super();
		this.id = id;
		this.date = date;
		setSchedulingStatus(schedulingStatus);
		this.client = client;
		this.barber = barber;
		this.totalValue = totalValue;
	}

	public Long getId() {
		return id;
	}

	public void setIg(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public SchedulingStatus getOrderStatus() {
		return SchedulingStatus.valueOf(schedulingStatus);
	}
	//USANDO O METEDO valueOf DO ENUM PARA PASSAR O OrderStatus QUE AQUI NESSA CLASSE E DO TIPO INTEGER

	public void setSchedulingStatus(SchedulingStatus schedulingStatus) {
		if(schedulingStatus != null) {
			this.schedulingStatus = schedulingStatus.getCode();
		}	
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public Client getClient() {
		return client;
	}
	
	public Barber getBarber() {
		return barber;
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
		Scheduling other = (Scheduling) obj;
		return Objects.equals(id, other.id);
	}

}
