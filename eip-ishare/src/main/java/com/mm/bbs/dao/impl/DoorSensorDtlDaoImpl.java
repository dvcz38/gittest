package com.mm.bbs.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mm.bbs.common.CheckState;
import com.mm.bbs.dao.DoorSensorDtlDao;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.util.TimeUtil;

 
@Repository("doorSensorDtlDao")
public class DoorSensorDtlDaoImpl extends BaseDaoImpl<DoorSensorDtl,String> implements DoorSensorDtlDao{

	@Resource
	private HibernateTemplate hibernateTemplate;
	
 
	
	public List<DoorSensorDtl> findDeviceByInd(Integer i) {
		// TODO Auto-generated method stub 
 
		return this.findDeviceByChnlNo(i, 0);
	}
	public List<DoorSensorDtl> findDeviceByChnlNo(Integer i,Integer channelNo){
		// TODO Auto-generated method stub 
		 
		return this.findDeviceByParams(i, null, channelNo,null);
	}
	public List<DoorSensorDtl> findDeviceByParams(Integer i,String staffCheckInd,Integer channelNo,String doorStatus){
	 return this.findDeviceByParams(i, null, staffCheckInd, channelNo, doorStatus);
	}
	public List<DoorSensorDtl> findDeviceByParams(Integer i,String deviceId,String staffCheckInd,Integer channelNo,String doorStatus){
		// TODO Auto-generated method stub 
		String ind="F";
		
		StringBuilder hql=new StringBuilder();
		hql.append("FROM DoorSensorDtl a where datediff(now(),a.inputDt)=? ");
		
		if(deviceId!=null) {
			hql.append("and a.device.id=? ");
		}
		if(channelNo>0) {
			hql.append("and a.device.channelNo=? ");
		}
		if(doorStatus!=null) {
			hql.append("and a.doorStatus=? ");
		}
		if (CheckState.Manulcheck.getValue().equals(staffCheckInd)) {
//			staffCheckInd="F";
			hql.append("and a.isStaffCheck='T' ");
		}else if(CheckState.Autocheck.getValue().equals(staffCheckInd)) {
			hql.append("and a.isStaffCheck='F' ");
		}
		hql.append("order by a.inputDt desc, a.device.channelNo ");
		System.out.println("====hql>"+hql.toString());
		Query query=this.getCurrentSession().createQuery(hql.toString());
		int position=0;
		query.setInteger(position,i);  
		position++;
		if(deviceId!=null) { 
			query.setString(position,deviceId);  
			position++;
		}
		if(channelNo>0) { 
			query.setInteger(position,channelNo); 
			position++;
		}
		if(doorStatus!=null) {
			query.setString(position,doorStatus);  
			position++;
		}
		List<DoorSensorDtl> lst = (List<DoorSensorDtl>)query.list();
		return lst;
	}
	
	
	public List<DoorSensorDtl> findDeviceByParams(String inputDt,String deviceId,String staffCheckInd,Integer channelNo,String doorStatus)
	{
		// TODO Auto-generated method stub 
		String ind="F";
		
		StringBuilder hql=new StringBuilder();
		hql.append("FROM DoorSensorDtl a where 1=1 ");
		if(inputDt!=null) {
			hql.append("and inputDt=? ");
		}
		if(deviceId!=null) {
			hql.append("and a.device.id=? ");
		}
		if(channelNo>0) {
			hql.append("and a.device.channelNo=? ");
		}
		if(doorStatus!=null) {
			hql.append("and a.doorStatus=? ");
		}
		
		if (CheckState.Manulcheck.getValue().equals(staffCheckInd)) {
			hql.append("and a.isStaffCheck='T' ");
		}else if(CheckState.Autocheck.getValue().equals(staffCheckInd)) {
			hql.append("and a.isStaffCheck='F' ");
		}
		hql.append("order by a.inputDt desc, a.device.channelNo ");
		System.out.println("====hql>"+"["+inputDt+"]"+hql.toString());
		Query query=this.getCurrentSession().createQuery(hql.toString());
		int position=0;
		
		if(inputDt!=null) {
			query.setString(position,inputDt);  
			position++;
		}
		if(deviceId!=null) { 
			query.setString(position,deviceId);  
			position++;
		}
		if(channelNo>0) { 
			query.setInteger(position,channelNo); 
			position++;
		}
		if(doorStatus!=null) {
			query.setString(position,doorStatus);  
			position++;
		}
		List<DoorSensorDtl> lst = (List<DoorSensorDtl>)query.list();
		return lst;
	}
	
	public List<DoorSensorDtl> findDeviceByParamsOnHour(String staffCheckInd,Integer channelNo,String doorStatus)  {
		// TODO Auto-generated method stub 
		String ind="F";
 
		StringBuilder hql=new StringBuilder();
		hql.append("FROM DoorSensorDtl a where  1=1 ");
 
		hql.append("and a.inputDt in (");		 
		List<Map<String, String>> lst;
		try {
			lst = TimeUtil.getAllHoursofDay();
			int f=lst.size()-1;
			for(int i=0;i<lst.size();i++) {
				Map map=lst.get(i);
				hql.append("'").append(map.get(String.valueOf(i))).append("'");
				 
				if(i!=f) {
					hql.append(",");
				} 
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hql.append(") ");
		if(channelNo>0) {
			hql.append("and a.device.channelNo=? ");
		}
		if(doorStatus!=null) {
			hql.append("and a.doorStatus=? ");
		}
		
		if (CheckState.Manulcheck.getValue().equals(staffCheckInd)) {
//			staffCheckInd="F";
			hql.append("and a.isStaffCheck='T' ");
		}else if(CheckState.Autocheck.getValue().equals(staffCheckInd)) {
			hql.append("and a.isStaffCheck='F' ");
		}
		hql.append("order by a.inputDt desc , a.device.channelNo");
		System.out.println("====hql>"+hql.toString());
		Query query=this.getCurrentSession().createQuery(hql.toString());
		int position=0;
 
		if(channelNo>0) { 
			query.setInteger(position,channelNo); 
			position++;
		}
		if(doorStatus!=null) {
			query.setString(position,doorStatus);  
			position++;
		}
		List<DoorSensorDtl> list = (List<DoorSensorDtl>)query.list();
		return list;
	}
	public List<DoorSensorDtl> findDeviceBtwDatetime(String deviceId,String checkState,String doorStatus,String fdate,String todate) {
		// TODO Auto-generated method stub
//		String staffCheck="F";
//		if (staffCheckInd==true) {
//			staffCheck="T";
//		}
//		Query query=session.createQuery(“from User user where user.name=? and user.age =? ”); 
		StringBuilder hql=new StringBuilder();
		hql.append("from DoorSensorDtl a where 1=1 ");
		hql.append("and a.inputDt>=? ");
		hql.append("and a.inputDt<=? ");  
		
		if(deviceId!=null) {
			hql.append("and a.device.id=? ");
		} 
		
		if (checkState!=null) { 
			hql.append("and a.isStaffCheck=? ");
		} 
		if(doorStatus!=null) {
			hql.append("and a.doorStatus=? ");
		}
		hql.append("order by a.inputDt desc, a.device.channelNo ");
		
		
		System.out.println("====hql>"+hql.toString());
		Query query=this.getCurrentSession().createQuery(hql.toString());
//		query.setString(0,checkState.getValue()); 
		query.setString(0, fdate); 
		query.setString(1,todate); 
		int position=2;
		  
		if(deviceId!=null) {
			query.setString(position,deviceId);  
			position++;
		} 
		
		if (checkState!=null) {
			query.setString(position,checkState);  
			position++;
		} 
		
		if(doorStatus!=null) {
			query.setString(position,doorStatus);  
			position++;
		}
		
		List<DoorSensorDtl> lst = (List<DoorSensorDtl>)query.list();
		return lst;
	}

	 
	public void batchImport(List<DoorSensorDtl> lst) {
	// TODO Auto-generated method stub
		if(lst !=null &&lst.size()>0) {
			for (DoorSensorDtl ds:lst) {
					this.save(ds); 
			} 
		}			
	}
 
	public void batchDelete(List<DoorSensorDtl> lst) {
		 
	 
		/*if(lst !=null &&lst.size()>0) {
			for (DoorSensorDtl ds:lst) {
					this.delete(ds); 
			} 
		}	*/
	}
	 
	public List getCount(String inputDt)  {
		// TODO Auto-generated method stub 
		String ind="F";
 
		StringBuilder hql=new StringBuilder();
		hql.append("select count(*) ,doorStatus from DoorSensorDtl a where a.inputDt=? group by doorStatus");  
		Query query=this.getCurrentSession().createQuery(hql.toString());
		query.setString(0,inputDt); 
	
		List lst =query.list();
		return lst;
 
	}
 

}
