package com.mm.bbs.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.bbs.dao.DoorSensorDao; 
import com.mm.bbs.pojo.DoorSensor; 
import com.mm.bbs.service.DoorSensorService;

@Service("doorSensorService")
public class DoorSensorServiceImpl implements DoorSensorService {

	
	@Autowired
	private DoorSensorDao doorSensorDao;
	@Override
	public void save(DoorSensor entity) {
		// TODO Auto-generated method stub
		doorSensorDao.save(entity);
	}

	@Override
	public void delete(DoorSensor entity) {
		// TODO Auto-generated method stub
		doorSensorDao.delete(entity);
		
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
//		doorSensorDao.
	}

	@Override
	public void update(DoorSensor entity) {
		// TODO Auto-generated method stub
		doorSensorDao.update(entity);
	}

	@Override
	public DoorSensor findById(Serializable id) {
		// TODO Auto-generated method stub
		return doorSensorDao.getById(DoorSensor.class, id);
	}

	@Override
	public List<DoorSensor> getAll() {
		// TODO Auto-generated method stub
		return doorSensorDao.findAll(DoorSensor.class);
	}

	@Override
	public List<DoorSensor> findDoorSensor(String deviceId, String deviceDesc, String channelNo, String floorNo,
			String state) {
		// TODO Auto-generated method stub
		return doorSensorDao.findDoorSensor(deviceId, deviceDesc, channelNo, floorNo, state);
	}

	@Override
	public List<DoorSensor> getChannel() {
		// TODO Auto-generated method stub
		return doorSensorDao.getChannel();
	}

}
