package com.mm.bbs.common;

public enum DeviceStatus { 
	
	/*PERIODIC_UPDATE("Periodic Update"),
	DOOR_CHANGED("Door Changed"),
	CONNECTED_AND_TIME_SYNCHRONIZED("Connected and Time Synchronized"),
	DISCONNECTED("Disconnected"),
	RECONNECT("Reconnect");*/
	
	CONNECTED("80"),
	DISCONNECTED("81"),
	RECONNECT("82"),
	TIME_SYNCHRONIZED("83"),
	ONNECTED_AND_TIME_SYNCHRONIZED("84"),
	PERIODIC_UPDATE("91"),
	DOOR_CHANGED("92");


	private final String state;
	private DeviceStatus(String state) {
		this.state=state;
	}
	
	public String getValue() {
		return state;
	}
	
	public static boolean isDoorCheck(String str) {
		boolean doorCheck=false;
		
		if(CONNECTED.getValue().equals(str)||DISCONNECTED.getValue().equals(str)
				||RECONNECT.getValue().equals(str)||TIME_SYNCHRONIZED.getValue().equals(str)
				||ONNECTED_AND_TIME_SYNCHRONIZED.getValue().equals(str)||PERIODIC_UPDATE.getValue().equals(str)||DOOR_CHANGED.getValue().equals(str)
				) {
			doorCheck=true;
		}
		return doorCheck;
	}
}
