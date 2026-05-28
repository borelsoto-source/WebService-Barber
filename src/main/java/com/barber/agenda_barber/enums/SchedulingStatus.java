package com.barber.agenda_barber.enums;

public enum SchedulingStatus {

	AGENDADO(1),
	CONCLUIDO(2),
	CANCELADO(3);

	private int code;
	
	private SchedulingStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static SchedulingStatus valueOf(int code) {
		for(SchedulingStatus value : SchedulingStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code"); 
	}
	
}
