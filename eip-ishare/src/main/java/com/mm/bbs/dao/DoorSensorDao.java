package com.mm.bbs.dao;

import java.util.List;

import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;

public interface DoorSensorDao extends BaseDao<DoorSensor, String> {

 
	List<String> getDoorChannel();
 
	List<DoorSensor> findDoorSensor(String deviceId, String deviceDesc, String channelNo, String floorNo, String state,
			String type);
}
