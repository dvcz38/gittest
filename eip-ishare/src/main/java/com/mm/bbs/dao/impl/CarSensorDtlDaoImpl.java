package com.mm.bbs.dao.impl;
 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mm.bbs.common.CheckState;
import com.mm.bbs.dao.CarSensorDtlDao; 
import com.mm.bbs.pojo.CarSensorDtl;
import com.mm.bbs.pojo.CarSensorDtl; 

@Repository("carrSensorDtlDao")
public class CarSensorDtlDaoImpl extends BaseDaoImpl<CarSensorDtl,String> implements  CarSensorDtlDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Override
	public List<CarSensorDtl> findDeviceByParams(Integer i,String deviceId,String carStatus){
		// TODO Auto-generated method stub 
		  
		StringBuilder hql=new StringBuilder();
		hql.append("FROM CarSensorDtl a where datediff(now(),a.inputDt)=? ");
		
		if(deviceId!=null) {
			hql.append("and a.device.id=? ");
		}
		 
		if(carStatus!=null) {
			hql.append("and a.carStatus=? ");
		}
		 
		hql.append("order by a.inputDt desc ");
		System.out.println("====hql>"+hql.toString());
		Query query=this.getCurrentSession().createQuery(hql.toString());
		int position=0;
		query.setInteger(position,i);  
		position++;
		if(deviceId!=null) { 
			query.setString(position,deviceId);  
			position++;
		} 
		if(carStatus!=null) {
			query.setString(position,carStatus);  
			position++;
		}
		List<CarSensorDtl> lst = (List<CarSensorDtl>)query.list();
		return lst;
	}
	@Override
	public List<CarSensorDtl> findDeviceBtwDatetime(String deviceId,String carStatus,String fdate,String todate) {
		// TODO Auto-generated method stub
 
		StringBuilder hql=new StringBuilder();
		hql.append("from CarSensorDtl a where 1=1 ");
		hql.append("and a.inputDt>=? ");
		hql.append("and a.inputDt<=? ");  
		
		if(deviceId!=null) {
			hql.append("and a.device.id=? ");
		} 
		
		 
		if(carStatus!=null) {
			hql.append("and a.carStatus=? ");
		}
		hql.append("order by a.inputDt desc ");
		
		
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
		 
		if(carStatus!=null) {
			query.setString(position,carStatus);  
			position++;
		}
		
		List<CarSensorDtl> lst = (List<CarSensorDtl>)query.list();
		return lst;
	}
}
