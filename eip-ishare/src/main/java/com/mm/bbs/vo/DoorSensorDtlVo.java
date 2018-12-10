package com.mm.bbs.vo;

import java.util.Date;

import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;

 

public class DoorSensorDtlVo {
	
	private Integer id;
	 
	private DoorSensor   device  ;
	  
	 
	private int   seqNo;
	 
	private float   nbSignalPwr  ;
	 
	private int   doorDistance  ;
	 
	private String   doorStatus  ;
	 
	private String   isStaffCheck  ;
	 
	private String   staffno  ;
	 
	private float battVol;
	
	private String inputDt;

	private String updateDt;
	
	public DoorSensorDtlVo() {
	  super();
	}
	public DoorSensorDtlVo(DoorSensorDtl ds) {
		this.battVol=ds.getBattVol();
		this.id=ds.getId();
		this.device=ds.getDevice();
		 
		this.doorDistance=ds.getDoorDistance();
		this.doorStatus=ds.getDoorStatus();
		this.isStaffCheck=ds.getIsStaffCheck();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DoorSensor getDevice () {
		return device ;
	}

	public void setDevice (DoorSensor device ) {
		this.device  = device ;
	}
 

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public float getNbSignalPwr() {
		return nbSignalPwr;
	}

	public void setNbSignalPwr(float nbSignalPwr) {
		this.nbSignalPwr = nbSignalPwr;
	}

	public int getDoorDistance() {
		return doorDistance;
	}

	public void setDoorDistance(int doorDistance) {
		this.doorDistance = doorDistance;
	}

	public String getDoorStatus() {
		return doorStatus;
	}

	public void setDoorStatus(String doorStatus) {
		this.doorStatus = doorStatus;
	}

	public String getIsStaffCheck() {
		return isStaffCheck;
	}

	public void setIsStaffCheck(String isStaffCheck) {
		this.isStaffCheck = isStaffCheck;
	}

	public String getStaffno() {
		return staffno;
	}

	public void setStaffno(String staffno) {
		this.staffno = staffno;
	}

	public float getBattVol() {
		return battVol;
	}

	public void setBattVol(float battVol) {
		this.battVol = battVol;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public String getInputDt() {
		return inputDt;
	}

	public void setInputDt(String inputDt) {
		this.inputDt = inputDt;
	}
	
	
}
