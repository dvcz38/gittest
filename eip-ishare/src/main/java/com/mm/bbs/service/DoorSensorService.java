package com.mm.bbs.service;

import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;

public interface DoorSensorService extends BaseService<DoorSensor>{
	
	 
	List<String> getChannel();

	XSSFWorkbook export(Date startDate, Date endDate);

	List<DoorSensor> findDoorSensor(String deviceId, String deviceDesc, String channelNo, String floorNo, String state,
			String type);
}
