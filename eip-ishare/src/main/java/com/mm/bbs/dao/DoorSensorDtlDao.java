package com.mm.bbs.dao;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.mm.bbs.inf.GenericInf;
import com.mm.bbs.pojo.DoorSensorDtl;
 
 

 
public interface DoorSensorDtlDao extends BaseDao<DoorSensorDtl, String> {
//	public DoorSensor findDiviceById(String deviceId);
	public List<DoorSensorDtl> findDiviceByStaffCheckOnDate(boolean staffCheckInd,Date fdate);
	public List<DoorSensorDtl> findDiviceByStaffCheck(boolean staffCheckInd,Date fdate,Date todate);
	 
}
