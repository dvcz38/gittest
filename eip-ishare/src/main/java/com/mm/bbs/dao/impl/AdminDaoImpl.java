package com.mm.bbs.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mm.bbs.dao.AdminDao;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.pojo.DoorSensorDtl;

@Repository("adminDao") 
public class AdminDaoImpl extends BaseDaoImpl<Admin,String> implements AdminDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Admin> findByAdmin(String name) {
		// TODO Auto-generated method stub
		String hql = "select new Admin(id,name,password,email,phone,joindate,role,state) from Admin where name = ?";
		return (List<Admin>) hibernateTemplate.find(hql,name);
	}

//	@Override
//	public List<Admin> findAdmins() {
//		// TODO Auto-generated method stub
//		String hql = "select new Admin(id,name,password,email,phone,joindate,role,state) from Admin";
//		return (List<Admin>) hibernateTemplate.find(hql);
//	}

}
