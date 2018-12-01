package com.mm.bbs.util;

public enum CheckState {
	Autocheck("F"), Manulcheck("T"); 
	
	private final String state;
	private CheckState(String state) {
		this.state=state;
	}
	
	public String getValue() {
		return state;
	}
}
