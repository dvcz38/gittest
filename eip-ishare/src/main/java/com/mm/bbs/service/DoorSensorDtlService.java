package com.mm.bbs.service;

import java.util.Date;
import java.util.List;

import com.mm.bbs.inf.GenericInf; 
import com.mm.bbs.pojo.DoorSensorDtl; 

 
//extends GenericInf<DoorSensorDtl, String>
public interface DoorSensorDtlService extends BaseService<DoorSensorDtl>{
 
	
	public List<DoorSensorDtl> findDiviceByStaffCheckOnDate(boolean staffCheckInd,Date fdate);
	public List<DoorSensorDtl> findDiviceByStaffCheck(boolean staffCheckInd,Date fdate,Date todate);
}
