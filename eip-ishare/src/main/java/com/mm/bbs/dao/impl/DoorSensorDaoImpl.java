package com.mm.bbs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mm.bbs.common.CheckState;
import com.mm.bbs.dao.DoorSensorDao; 
import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl; 

@Repository("doorSensorDao")
public class DoorSensorDaoImpl extends BaseDaoImpl<DoorSensor,String> implements DoorSensorDao{

	@Override
	public List<String>  getDoorChannel() {
		// TODO Auto-generated method stub
		Long i=(long) 0;
		StringBuilder hql=new StringBuilder();
		hql.append("select distinct channelNo from DoorSensor where state=1 ");
 

		Query query=this.getCurrentSession().createQuery(hql.toString());
		List<String> lst = (List<String>)query.list();
		return lst;
	}
	
	@Override
	public List<DoorSensor> findDoorSensor(String deviceId,String deviceDesc,String channelNo,String floorNo,String state,String type) {
		// TODO Auto-generated method stub
		StringBuilder hql=new StringBuilder();
		hql.append("from DoorSensor a where 1=1 "); 

		if(deviceId!=null) {
			hql.append("and a.id=? ");
		}
		if(deviceDesc!=null) {
			hql.append("and a.deviceDesc=? ");
		}
		if(channelNo!=null) {
			hql.append("and a.channelNo=? ");
		}
		 
		if(floorNo!=null) {
			hql.append("and a.floorNo=? ");
		}
		if(state!=null) {
			hql.append("and a.state=? ");
		}
		if(type!=null) {
			hql.append("and a.type=? ");
		}
		 
//		hql.append("order by a.channelNo, a.instalDt desc ");
		System.out.println("====hql>"+hql.toString());
		Query query=this.getCurrentSession().createQuery(hql.toString());
		int position=0;
//		query.setInteger(position,i);  
//		position++;
		if(deviceId!=null) {
//			hql.append("and a.device.id=? ");
			query.setString(position,deviceId);  
			position++;
		}
		if(deviceDesc!=null) {
			query.setString(position,deviceDesc);  
			position++;
		}
		if(channelNo!=null) {
			query.setString(position,channelNo); 
			position++;
		}
		if(floorNo!=null) {
			query.setString(position,floorNo); 
			position++;
		}
		if(state!=null) {
			query.setString(position,state);  
			position++;
		}
		if(type!=null) {
			query.setString(position,type);  
			position++;
		}
		List<DoorSensor> lst = (List<DoorSensor>)query.list();
		return lst;
	}
	
	 

}
