package com.mm.bbs.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "doorsensor")
public class DoorSensorDtl {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="deviceId",referencedColumnName="id",updatable=false,insertable=false)
	private DoorSensor device  ;
//	@Column(name = "deviceDesc")
//	private String   deviceDesc  ;
//	@Column(name = "seqNo")
//	private int   seqNo;
	@Column(name = "nbSignalPwr")
	private float   nbSignalPwr  ;
	@Column(name = "doorDistance")
	private int   doorDistance  ;
	@Column(name = "doorStatus")
	private String   doorStatus  ;
	@Column(name = "isStaffCheck")
	private String   isStaffCheck  ;
	@Column(name = "staffno")
	private String   staffno  ;
	
	@Column(name = "battVol")
	private float battVol;
	
	@JsonFormat(pattern="yyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Column(name = "inputDt")
	private Date inputDt;
	
	@JsonFormat(pattern="yyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Column(name = "updateDt")
	private Date updateDt;
	
	public DoorSensorDtl() {
		super();
	}
	public DoorSensorDtl(int id, DoorSensor device, float nbSignalPwr,int doorDistance, 
			String doorStatus,String isStaffCheck,String staffno,float battVol,Date inputDt, Date updateDt){
		super();
		this.id = id;
		this.device = device;
//		this.deviceDesc = deviceDesc;
//		this.seqNo = seqNo;
		this.nbSignalPwr = nbSignalPwr;
		this.doorDistance = doorDistance;
		this.doorStatus = doorStatus;
		this.isStaffCheck = isStaffCheck;
		this.staffno = staffno;

		this.battVol = battVol;
		this.inputDt = inputDt;
		this.updateDt = updateDt;
		
		 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getInputDt() {
		return inputDt;
	}
	
	public void setInputDt(Date inputDt) {
		this.inputDt = inputDt;
	}
	
	public DoorSensor getDevice () {
		return device;
	}
	public void setDevice (DoorSensor device ) {
		this.device  = device ;
	}
	public float getBattVol() {
		return battVol;
	}
	public void setBattVol(float battVol) {
		this.battVol = battVol;
	}

//	public String getDeviceDesc() {
//		return deviceDesc;
//	}
//	public void setDeviceDesc(String deviceDesc) {
//		this.deviceDesc = deviceDesc;
//	}
//	
//	public int getSeqNo() {
//		return seqNo;
//	}
//	public void setSeqNo(int seqNo) {
//		this.seqNo = seqNo;
//	}
	
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

	public Date getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	} 
}
