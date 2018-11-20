package com.mm.bbs.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 

import org.hibernate.Query;
 
import org.springframework.stereotype.Repository; 

import com.mm.bbs.dao.DoorSensorDtlDao;
import com.mm.bbs.pojo.DoorSensorDtl;

 
@Repository("doorSensorDtlDao")
public class DoorSensorDtlDaoImpl extends BaseDaoImpl<DoorSensorDtl,String> implements DoorSensorDtlDao{

 
	public List<DoorSensorDtl> findDiviceByStaffCheckOnDate(boolean staffCheckInd, Date fdate) {
		// TODO Auto-generated method stub
		String staffCheck="F";
		if (staffCheckInd=true) {
			staffCheck="Y";
		}
		String hql="from DoorSensorDtl where isStaffCheck=:checkInd and inputdt=:inputdate ";
		Map<String, Object> params =new HashMap<String, Object>();
		params.put("checkInd", staffCheck);
		params.put("inputdate",fdate);
//		.find("from DoorSensorDtl where isStaffCheck=? and inputdt=? ", staffCheck,fdate);
//		this.getCurrentSession().createQuery(queryString)
		List<DoorSensorDtl> lst = (List<DoorSensorDtl>)this.findByHQL(DoorSensorDtl.class, hql, params);
		return lst;
	}

	
	public List<DoorSensorDtl> findDiviceByStaffCheck(boolean staffCheckInd, Date fdate, Date todate) {
		// TODO Auto-generated method stub
		String staffCheck="F";
		if (staffCheckInd=true) {
			staffCheck="Y";
		}
//		Query query=session.createQuery(“from User user where user.name=? and user.age =? ”); 
		Query query=this.getCurrentSession().createQuery("from DoorSensorDtl where isStaffCheck=? and inputdt>? and inputdt>?");
		query.setString(0,staffCheck); 
		query.setDate(1, fdate); 
		query.setDate(2,todate); 
//		, staffCheck,fdate, todate
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


	 


 




}
