package com.mm.bbs.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "carsensor")
public class CarSensorDtl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="deviceId",referencedColumnName="id",updatable=true,insertable=true)	
	@NotFound(action=NotFoundAction.IGNORE)
	private DoorSensor device  ;
	
	@Column(name = "nbSignalPwr")
	private float   nbSignalPwr; 
	@Column(name = "battVol")
 	private float battVol;
	@Column(name = "dataType")
 	private String dataType;
	@Column(name = "dataLen")
	private String dataLen;
	@Column(name = "carStatus")
 	private String carStatus;
	

	@JsonFormat(pattern="yyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Column(name = "inputDt")
 	private Date inputDt;
	@JsonFormat(pattern="yyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Column(name = "updateDt")
 	private Date updateDt;
	
	public CarSensorDtl() {
		super();
	}
	
	public CarSensorDtl(int id, DoorSensor device, float nbSignalPwr, float battVol ,String carStatus,Date inputDt, Date updateDt,String dataType,String dataLen){
		
		super();
		this.id = id;
		this.device = device; 
		this.nbSignalPwr = nbSignalPwr;  
		this.carStatus = carStatus; 
		this.battVol = battVol;
		this.inputDt = inputDt;
		this.updateDt = updateDt;
		this.dataLen=dataLen;
		this.dataType=dataType; 
		 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDataLen() {
		return dataLen;
	}
	public void setDataLen(String dataLen) {
		this.dataLen = dataLen;
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
	public Date getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	} 
}
