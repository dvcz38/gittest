package com.mm.bbs.common;

public enum DeviceStatus { 
	
	PERIODIC_UPDATE("Periodic Update"),
	DOOR_CHANGED("Door Changed"),
	CONNECTED_AND_TIME_SYNCHRONIZED("Connected and Time Synchronized"),
	DISCONNECTED("Disconnected"),
	RECONNECT("Reconnect");


	private final String state;
	private DeviceStatus(String state) {
		this.state=state;
	}
	
	public String getValue() {
		return state;
	}
}
