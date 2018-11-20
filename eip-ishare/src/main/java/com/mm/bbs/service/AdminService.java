package com.mm.bbs.service;

import java.util.List;

import com.mm.bbs.pojo.Admin; 

public interface AdminService extends BaseService<Admin>{

	//登录 管理员
	public List<Admin> findByAdmin(String name);
	 
}
