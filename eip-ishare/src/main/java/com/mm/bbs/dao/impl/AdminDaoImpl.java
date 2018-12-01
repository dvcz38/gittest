package com.mm.bbs.dao.impl;

import com.mm.bbs.dao.AdminDao;
import com.mm.bbs.pojo.Admin;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query; 
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("adminDao")
public class AdminDaoImpl
  extends BaseDaoImpl<Admin, String>
  implements AdminDao
{
  @Resource
  private HibernateTemplate hibernateTemplate;
  
  public List<Admin> findByAdmin(String name)
  {
    String hql = "select new Admin(id,name,password,email,phone,joindate,role,state) from Admin where name = ?";
    return (List<Admin>) this.hibernateTemplate.find(hql, name);
  }
  
  public List<Admin> find(int page, int rows)
  {
    String hql = "from Admin";
    Query query = getCurrentSession().createQuery(hql);
    return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
  }
}
