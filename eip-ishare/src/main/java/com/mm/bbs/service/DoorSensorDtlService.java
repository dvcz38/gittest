package com.mm.bbs.service;

import java.util.Date;
import java.util.List;


import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.util.CheckState; 

 
//extends GenericInf<DoorSensorDtl, String>
public interface DoorSensorDtlService extends BaseService<DoorSensorDtl>{
 
	
//	public List<DoorSensorDtl> findDeviceByStaffCheckOnDate(boolean staffCheckInd,String fdate);
	
	
	public List<DoorSensorDtl> findDeviceByInd(Integer i);
	public List<DoorSensorDtl> findDeviceByChnlNo(Integer i,Integer channelNo);  
	public List<DoorSensorDtl> findDeviceOnDatetime(String inputDt, String checkState,Integer channelNo, String doorState);
	public List<DoorSensorDtl> findManulCheckDeviceOnCurrentDay(Integer channelNo, String doorState);
//	public List<DoorSensorDtl> findAutoCheckDeviceInTime(String channelNo,String fdate);
//	public Long getDoorSensorCountAll();
//	public Long getDoorSensorCountByState(String ind,String inputDt);
//	public Long getDoorSensorCountByState(String ind,Date inputDt);
	
	List<DoorSensorDtl> findAutoCheckDeviceOnHour(Integer channelNo, String doorState); 
	List<DoorSensorDtl> findDeviceBtwDatetime(CheckState checkState,String fdate,String todate); 
	List<DoorSensorDtl> findDeviceOnCurrentDay(Integer channelNo,String deviceId, String checkState,String doorState);
}
