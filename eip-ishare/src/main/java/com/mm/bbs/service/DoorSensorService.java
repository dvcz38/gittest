package com.mm.bbs.service;

import java.util.List;

import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;

public interface DoorSensorService extends BaseService<DoorSensor>{
	
	List<DoorSensor> findDoorSensor(String deviceId, String deviceDesc, String channelNo, String floorNo, String state);

	List<DoorSensor> getChannel();
}
