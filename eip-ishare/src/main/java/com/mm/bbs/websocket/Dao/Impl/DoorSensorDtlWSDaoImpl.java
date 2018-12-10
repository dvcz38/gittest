package com.mm.bbs.websocket.Dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.util.DBUtil;
import com.mm.bbs.websocket.Dao.DoorSensorDtlWSDao;

public class DoorSensorDtlWSDaoImpl implements DoorSensorDtlWSDao {

	public List<DoorSensorDtl> getCurrentDayRecord() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException
	{

        List list=new ArrayList<DoorSensorDtl>();

        DBUtil db=new DBUtil();
        Connection conn= db.getConn() ; 
        Statement stat=conn.createStatement();
        
        StringBuilder sb=new StringBuilder();
        
        sb.append("select a.*,b.deviceDesc,b.channelNo,b.floorNo,b.state from doorsensor a left join device b on a.deviceId= b.id where datediff(now(),a.inputDt)=0 ");
//        FROM DoorSensorDtl a where datediff(now(),a.inputDt)=
//        String sql="select * from device";

        ResultSet rs=stat.executeQuery(sb.toString());

        while (rs.next()){
//        	public DoorSensor(int id, String deviceDesc, int floorNo,int channelNo,String state,Date instalDt)
        	System.out.println(rs.getInt("id")+" "
        			          +rs.getString("deviceId"));
        	
//        	public DoorSensorDtl(int id, DoorSensor device, float nbSignalPwr,int doorDistance, 
//        			String doorStatus,String isStaffCheck,String staffno,float battVol,Date inputDt, Date updateDt){
        	DoorSensor ds=new DoorSensor();
        	ds.setId(rs.getInt("deviceId"));
        	ds.setDeviceDesc(rs.getString("deviceDesc")); 
        	ds.setChannelNo(rs.getInt("channelNo")); 
        	DoorSensorDtl item=new DoorSensorDtl(
        			rs.getInt("id"),
        			ds, 
        			rs.getFloat("nbSignalPwr"),
        			rs.getInt("doorDistance"),
        			rs.getString("doorStatus"),
        			rs.getString("isStaffCheck"),
        			rs.getString("staffno"),
        			rs.getFloat("battVol"),
        			rs.getDate("inputDt"), 
        			new Date());

            list.add(item);

        }

        rs.close(); 
        stat.close(); 
        conn.close();

        return list;

    }

	@Override
	public int getCurrentDayRecordCount()
			throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
	 
		int count=0;

        DBUtil db=new DBUtil();
        Connection conn= db.getConn() ; 
        Statement stat=conn.createStatement();
        
        StringBuilder sb=new StringBuilder();
        sb.append("select count(*) as count from doorsensor a where datediff(now(),a.inputDt)=0 ");
        

        ResultSet rs=stat.executeQuery(sb.toString());

        while (rs.next()){
   	 
        	count=rs.getInt("count");  
        }
        rs.close(); 
        stat.close(); 
        conn.close();

        return count;

    }
	
	@Override
	public List<DoorSensor> getCurrentTimeLossDevice(String inputDt)
			throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
	 
		List list=new ArrayList<DoorSensor>();

        DBUtil db=new DBUtil();
        Connection conn= db.getConn() ; 
        Statement stat=conn.createStatement();
        
        StringBuilder sb=new StringBuilder();
        sb.append("	select b.* from device b ")
        .append("where b.id not in (")
        .append("select distinct a.deviceId from doorsensor a where a.inputDt='")
        .append(inputDt).append("')");
        

        ResultSet rs=stat.executeQuery(sb.toString());

        while (rs.next()){
   	 
        	DoorSensor ds=new DoorSensor();
        	ds.setId(rs.getInt("deviceId"));
        	ds.setDeviceDesc(rs.getString("deviceDesc")); 
        	ds.setChannelNo(rs.getInt("channelNo")); 
        	ds.setInstalDt(rs.getDate("instalDt"));
        	ds.setState(rs.getString("state"));
        	list.add(ds);

        }

        rs.close(); 
        stat.close(); 
        conn.close();

        return list;

    }

	@Override
	public int save(String deviceId,String inputDt,String doorDistance,String doorStatus,String isStaffCheck,String signlpwr,String batVol) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int count=0;

        DBUtil db=new DBUtil();
        Connection conn= db.getConn() ; 
        Statement stat=conn.createStatement();
        
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO fordream.doorsensor (deviceId, inputDt, doorDistance, doorStatus, isStaffCheck, nbSignalPwr, battVol) VALUES ( '");
        sb.append(deviceId).append("','");
        sb.append(inputDt).append("','");
        sb.append(doorDistance).append("','");
        sb.append(doorStatus).append("','");
        sb.append(isStaffCheck).append("','");
        sb.append(signlpwr).append("','");
        sb.append(batVol).append("')");
        System.out.println("SQL==>"+sb.toString());
        int ret =stat.executeUpdate(sb.toString());

//        while (rs.next()){
//   	 
//        	count=rs.getInt("count"); 
//
//        }

//        rs.close(); 
        stat.close(); 
        conn.close();

        return ret;

	}
}
