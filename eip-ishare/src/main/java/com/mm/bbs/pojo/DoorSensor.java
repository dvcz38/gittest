package com.mm.bbs.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "device")
public class DoorSensor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id; 
	@Column(name = "deviceDesc")
	private String   deviceDesc ;
	@Column(name = "floorNo")
	private int   floorNo;
	@Column(name = "channelNo")
	private int   channelNo; 
	@Column(name = "state")
	private String   state ;
	@JsonFormat(pattern="yyy-M-dd HH:mm:ss",timezone = "GMT+8")
	@Column(name = "instalDt")
	private Date instalDt;
	 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceDesc() {
		return deviceDesc;
	}
	public void setDeviceDesc(String deviceDesc) {
		this.deviceDesc = deviceDesc;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public int getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(int channelNo) {
		this.channelNo = channelNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getInstalDt() {
		return instalDt;
	}
	public void setInstalDt(Date instalDt) {
		this.instalDt = instalDt;
	}
	public DoorSensor() {
		super();
	}
	public DoorSensor(int id, String deviceDesc, int floorNo,int channelNo,String state,Date instalDt){
		super();
		this.id = id; 
		this.deviceDesc = deviceDesc;
		this.floorNo = floorNo;
		this.channelNo = channelNo;
		this.state = state; 
		this.instalDt = instalDt;
	}
	
	
}
