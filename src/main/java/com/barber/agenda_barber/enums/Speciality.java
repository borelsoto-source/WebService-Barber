package com.barber.agenda_barber.enums;

public enum Speciality {

	DEGRADE(1),
	BARBA(2),
	SOCIAL(3),
	INFANTIL(4),
	SOMBRANCELHA(5),
	PROGRESSIVA(6);

	private int code;
	
	private Speciality(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Speciality valueOf(int code) {
		for(Speciality value : Speciality.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code"); 
	}
	
}
