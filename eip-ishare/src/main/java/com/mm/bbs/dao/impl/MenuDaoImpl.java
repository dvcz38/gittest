package com.mm.bbs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mm.bbs.dao.MenuDao;
import com.mm.bbs.pojo.MenuCode;
import com.mm.bbs.vo.TreeDataVo;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<MenuCode> finds() {
		// TODO Auto-generated method stub
		String hql = "from MenuCode m";
		List<MenuCode> list =  new ArrayList<>();
		
		return (List<MenuCode>) hibernateTemplate.find(hql);
	}	
}
