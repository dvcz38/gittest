package com.mm.bbs.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mm.bbs.dao.DoorSensorDao; 
import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.util.CheckState; 

@Repository("doorSensorDao")
public class DoorSensorDaoImpl extends BaseDaoImpl<DoorSensor,String> implements DoorSensorDao{

	@Override
	public List<DoorSensor>  getChannel() {
		// TODO Auto-generated method stub
		Long i=(long) 0;
		StringBuilder hql=new StringBuilder();
		hql.append("from DoorSensor where state=1 group by channelNo");
 

		Query query=this.getCurrentSession().createQuery(hql.toString());
		List<DoorSensor> lst = (List<DoorSensor>)query.list();
		return lst;
	}
	
	@Override
	public List<DoorSensor> findDoorSensor(String deviceId,String deviceDesc,String channelNo,String floorNo,String state) {
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
		List<DoorSensor> lst = (List<DoorSensor>)query.list();
		return lst;
	}
	
	 

}
