package com.mm.bbs.service;

import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mm.bbs.common.CheckState;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.pojo.DoorSensorDtl; 

 
//extends GenericInf<DoorSensorDtl, String>
public interface DoorSensorDtlService extends BaseService<DoorSensorDtl>{
 
	
//	public List<DoorSensorDtl> findDeviceByStaffCheckOnDate(boolean staffCheckInd,String fdate);
	public List getDoorStatusCount(String inputDt);
	public List<DoorSensorDtl> findPage(int page, int rows);
	public List<DoorSensorDtl> findDeviceByInd(Integer i);
	public List<DoorSensorDtl> findDeviceByChnlNo(Integer i,Integer channelNo);  
	public List<DoorSensorDtl> findDeviceOnDatetime(String inputDt,String deviceId, String checkState,Integer channelNo, String doorState);
	public List<DoorSensorDtl> findManulCheckDeviceOnCurrentDay(Integer channelNo, String doorState);

	
	List<DoorSensorDtl> findAutoCheckDeviceOnHour(Integer channelNo, String doorState); 
	List<DoorSensorDtl> findDeviceBtwDatetime(String deviceId,String checkState,String doorState,String fdate,String todate); 
	List<DoorSensorDtl> findDeviceOnCurrentDay(Integer channelNo,String deviceId, String checkState,String doorState);

	 public XSSFWorkbook export(Date startDate, Date endDate);
}
