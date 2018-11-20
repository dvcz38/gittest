package com.mm.bbs.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mm.bbs.dao.AdminDao;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminDao adminDao;

	@Override
	public List<Admin> findByAdmin(String name) {
		// TODO Auto-generated method stub
		return adminDao.findByAdmin(name);
	}
  
	@Override
	public void save(Admin entity) {
		// TODO Auto-generated method stub
		adminDao.save(entity);
	}

	@Override
	public void delete(Admin entity) {
		// TODO Auto-generated method stub
		adminDao.delete(entity);
	}

	@Override
	public void update(Admin entity) {
		// TODO Auto-generated method stub
		adminDao.update(entity);
	}

	@Override
	public Admin findById(Serializable id) {
		// TODO Auto-generated method stub
		return adminDao.getById(Admin.class, id);
	}

	@Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return adminDao.findAll(Admin.class);
	}

	

}
