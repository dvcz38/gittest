package com.mm.bbs.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.bbs.dao.DoorSensorDtlDao; 
import com.mm.bbs.pojo.DoorSensorDtl; 
import com.mm.bbs.service.DoorSensorDtlService;
import com.mm.bbs.util.CheckState;

@Service("doorSensorDtlService")
public class DoorSensorDtlServiceImpl implements DoorSensorDtlService {
	
	private static final Logger log = Logger
			.getLogger(DoorSensorDtlServiceImpl.class);
	
	@Autowired
	private DoorSensorDtlDao doorSensorDtlDao; 

	@Override
	public void save(DoorSensorDtl entity) {
		// TODO Auto-generated method stub
		doorSensorDtlDao.save(entity);
	}

	@Override
	public void delete(DoorSensorDtl entity) {
		// TODO Auto-generated method stub
		doorSensorDtlDao.delete(entity);
	}

	@Override
	public void update(DoorSensorDtl entity) {
		// TODO Auto-generated method stub
		doorSensorDtlDao.saveOrUpdate(entity);
	}

	@Override
	public DoorSensorDtl findById(Serializable id) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.getById(DoorSensorDtl.class, id.toString());
	}

	@Override
	public List<DoorSensorDtl> getAll() {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findAll(DoorSensorDtl.class);
	}
	 
	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		DoorSensorDtl entity=findById(id);
		if(entity !=null)
			this.delete(entity);
	}

	@Override
	public List<DoorSensorDtl> findDeviceByInd(Integer i) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDeviceByInd(i);
	}

	@Override
	public List<DoorSensorDtl> findDeviceByChnlNo(Integer i, Integer channelNo) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDeviceByChnlNo(i, channelNo);
	}
//	@Override
//	public List<DoorSensorDtl> findDeviceByStaffCheckOnDate(boolean staffCheckInd, String fdate) {
//		// TODO Auto-generated method stub
//		return doorSensorDtlDao.(staffCheckInd, fdate);
//	}
	
	public List<DoorSensorDtl> findDeviceOnCurrentDay(Integer channelNo,String deviceId, String checkState,String doorStatus)
	{ 
		return doorSensorDtlDao.findDeviceByParams(0,deviceId,checkState, channelNo, doorStatus);
	}

	@Override
	public List<DoorSensorDtl> findDeviceBtwDatetime(CheckState checkState, String fdate, String todate) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDeviceBtwDatetime(checkState, fdate, todate);
	}
	
	@Override
	public List<DoorSensorDtl> findDeviceOnDatetime(String inputDt, String checkState, Integer channelNo, String doorStatus)
	{
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDeviceByParams(inputDt, checkState, channelNo, doorStatus);
	}
	public List<DoorSensorDtl> findManulCheckDeviceOnCurrentDay(Integer channelNo, String doorStatus){
		
		return doorSensorDtlDao.findDeviceByParams(0,CheckState.Manulcheck.getValue(), channelNo, doorStatus);
	}
	/*************************************************************************************************************
	 * 
	 * 
	 */
	@Override
	public List<DoorSensorDtl> findAutoCheckDeviceOnHour(Integer channelNo, String doorStatus) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDeviceByParamsOnHour(CheckState.Autocheck.getValue(), channelNo, doorStatus);
	}

 
	
	
}
