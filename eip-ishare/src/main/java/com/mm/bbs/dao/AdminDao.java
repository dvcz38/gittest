package com.mm.bbs.dao;


import java.util.List;

import com.mm.bbs.pojo.Admin;
import com.mm.bbs.pojo.DoorSensorDtl;

public interface AdminDao extends BaseDao<Admin, String>{
	
	//登录 管理员
	public List<Admin> findByAdmin(String name);
	
//	public List<Admin> findAdmins();
}
