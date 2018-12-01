package com.mm.bbs.service;

import com.mm.bbs.dao.AdminDao;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.util.CryptographyUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl
  implements AdminService
{
  @Resource
  private AdminDao adminDao;
  
  public List<Admin> findByAdmin(String name)
  {
    return this.adminDao.findByAdmin(name);
  }
  
  public void save(Admin entity)
  {
    this.adminDao.save(entity);
  }
  
  public void delete(Admin entity)
  {
    this.adminDao.delete(entity);
  }
  
  public void update(Admin entity)
  {
    this.adminDao.update(entity);
  }
  
  public void updatePSWById(String id, String psw)
  {
    Admin admin = findById(id);
    String str = CryptographyUtil.md5(psw, "ADMIN-10001");
    admin.setPassword(str);
    update(admin);
  }
  
  public Admin findById(Serializable id)
  {
    return (Admin)this.adminDao.getById(Admin.class, id);
  }
  
  public Admin getById(int id)
  {
    return (Admin)this.adminDao.getById(Admin.class, Integer.valueOf(id));
  }
  
  public List<Admin> getAll()
  {
    return this.adminDao.findAll(Admin.class);
  }
  
  public void deleteById(Serializable id)
  {
    Admin entity = findById(id);
    if (entity != null) {
      this.adminDao.delete(entity);
    }
  }
  
  public List<Admin> find(int page, int rows)
  {
    return this.adminDao.find(page, rows);
  }
}
