package com.mm.bbs.dao;

import com.mm.bbs.pojo.Admin;
import java.util.List;


public abstract interface AdminDao
  extends BaseDao<Admin, String>
{
  public abstract List<Admin> findByAdmin(String paramString);
  /**
   * paganation
   * @param paramInt1
   * @param paramInt2
   * @return
   */
  public abstract List<Admin> find(int paramInt1, int paramInt2);
}
