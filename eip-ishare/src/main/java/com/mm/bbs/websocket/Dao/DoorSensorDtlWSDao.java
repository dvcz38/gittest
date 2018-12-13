package com.mm.bbs.websocket.Dao;

import java.sql.SQLException;
import java.util.List;

import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.util.CheckState;
 
 

 
public interface DoorSensorDtlWSDao  {
//	public DoorSensor findDeviceById(String deviceId);
	/**
	 * 
	 * @param i=0,返回当天所有设备数据
	 * @return
	 */
//	public List<DoorSensorDtl> findDeviceByInd(Integer i);
//	public List<DoorSensorDtl> findDeviceByChnlNo(Integer i,Integer channelNo); 
//	public List<DoorSensorDtl> findDeviceBtwDatetime(CheckState checkState,String fdate,String todate);

 
	/**
	 * 查询某时刻的记录
	 * @param inputDt 数据记录时间
	 * @param staffCheckInd 自动巡查 为 F, 人工巡查为T
	 * @param channelNo 通道号 1 2 3 4
	 * @param doorState 门关闭状态 Close Open
	 * @return
	 */
//	public List<DoorSensorDtl> findDeviceByParams(String inputDt,String deviceId,String staffCheckInd,Integer channelNo,String doorState);
	/**
	 * 查询当天或昨天的记录
	 * @param i=0 查询当天记录,i=1 查询昨天记录
	 * @param staffCheckInd 自动巡查 为 F, 人工巡查为T
	 * @param channelNo 通道号 1 2 3 4
	 * @param doorState 门关闭状态 Close Open
	 * @return
	 */
//	public List<DoorSensorDtl> findDeviceByParams(Integer i,String staffCheckInd,Integer channelNo,String doorState);
	/**
	 * 查询当天或昨天的记录
	 * @param i=0 查询当天记录,i=1 查询昨天记录
	 * @param deviceId 设备号
	 * @param staffCheckInd 自动巡查 为 F, 人工巡查为T
	 * @param channelNo 通道号 1 2 3 4
	 * @param doorState 门关闭状态 Close Open
	 * @return
	 */
//	public List<DoorSensorDtl> findDeviceByParams(Integer i,String deviceId,String staffCheckInd,Integer channelNo,String doorStatus);
	/**
	 * 自动查询当天 每小时 的所有记录
	 * @param staffCheckInd
	 * @param channelNo
	 * @param doorState
	 * @return
	 */
//	public List<DoorSensorDtl> findDeviceByParamsOnHour(String staffCheckInd,Integer channelNo,String doorState);
//	public List getCount(String inputDt) ;
	int getCurrentDayRecordCount() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

//	public List getCurrentDayRecord() ;
	List<DoorSensorDtl> getCurrentDayRecord() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;
	 
//	public Long getDoorSensorCountAll();
//	public Long getDoorSensorCountByState(String ind,String inputDt);
//	public Long getDoorSensorCountByState(String ind,Date inputDt);
//	public List<DoorSensorDtl> findManulCheckDevice(String todate);

	int save(String deviceId, String inputDt, String doorDistance, String doorStatus, String isStaffCheck,
			String signlpwr, String batVol) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	List<DoorSensor> getCurrentTimeLossDevice(String inputDt)
			throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;
}
