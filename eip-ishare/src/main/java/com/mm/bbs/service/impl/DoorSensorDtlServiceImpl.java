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

@Service("doorSensorService")
public class DoorSensorDtlServiceImpl implements DoorSensorDtlService {
	
	private static final Logger log = Logger
			.getLogger(DoorSensorDtlServiceImpl.class);
	
	@Autowired
	private DoorSensorDtlDao doorSensorDtlDao;

	@Override
	public List<DoorSensorDtl> findDiviceByStaffCheckOnDate(boolean staffCheckInd, Date fdate) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDiviceByStaffCheckOnDate(staffCheckInd, fdate);
	}

	@Override
	public List<DoorSensorDtl> findDiviceByStaffCheck(boolean staffCheckInd, Date fdate, Date todate) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDiviceByStaffCheck(staffCheckInd, fdate, todate);
	}

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

	
}
