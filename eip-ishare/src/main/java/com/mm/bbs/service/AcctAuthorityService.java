package com.mm.bbs.service;

import java.util.List;

import com.mm.bbs.pojo.AcctAuthority;
 
public interface AcctAuthorityService extends BaseService<AcctAuthority>  {
	public abstract AcctAuthority getById(int paramInt);
	
	public List<AcctAuthority> findPage(int page,int rows);
}
