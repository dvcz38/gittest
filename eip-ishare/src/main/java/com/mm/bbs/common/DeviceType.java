package com.mm.bbs.common;

public enum DeviceType {
	DOOR("D"), WATER("W"), CAR("C"), TEMPERATURE("T"); 
	
	private final String state;
	private DeviceType(String state) {
		this.state=state;
	}
	
	public String getValue() {
		return state;
	}
}
