package com.mm.bbs.dao.impl;

 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mm.bbs.dao.AcctAuthorityDao; 
import com.mm.bbs.pojo.AcctAuthority;
 

@Repository("acctAuthorityDao")
public class AcctAuthorityDaoImp extends BaseDaoImpl<AcctAuthority,String> implements AcctAuthorityDao {
	
	 
}
