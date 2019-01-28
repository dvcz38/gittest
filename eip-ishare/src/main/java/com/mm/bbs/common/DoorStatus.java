package com.mm.bbs.common;

public enum DoorStatus {
	DOOR_OPEN("Open"), DOOR_CLOSE("Close"); 
	
	private final String state;
	private DoorStatus(String state) {
		this.state=state;
	}
	
	public String getValue() {
		return state;
	}
}
