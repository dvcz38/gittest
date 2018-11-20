package com.mm.bbs.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.bbs.dao.AcctAuthorityDao;
import com.mm.bbs.pojo.AcctAuthority;
import com.mm.bbs.service.AcctAuthorityService;

@Service("acctAuthorityService")
public class AcctAuthorityServiceImpl implements AcctAuthorityService {
	
	private static final Logger log = Logger
			.getLogger(AcctAuthorityServiceImpl.class);
	
	@Autowired
	private AcctAuthorityDao acctAuthorityDao;

	@Override
	public void save(AcctAuthority entity) {
		// TODO Auto-generated method stub
		acctAuthorityDao.save(entity);
	}

	@Override
	public void delete(AcctAuthority entity) {
		// TODO Auto-generated method stub
		acctAuthorityDao.delete(entity);
	}

	@Override
	public void update(AcctAuthority entity) {
		// TODO Auto-generated method stub
		acctAuthorityDao.update(entity);
	}

	@Override
	public AcctAuthority findById(Serializable id) {
		// TODO Auto-generated method stub
		return acctAuthorityDao.getById(AcctAuthority.class, id);
	}

	@Override
	public List<AcctAuthority> getAll() {
		return acctAuthorityDao.findAll(AcctAuthority.class);
	}
	
}
 
	
