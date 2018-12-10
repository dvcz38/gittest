package com.mm.bbs.service;

import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mm.bbs.pojo.Admin; 


public abstract interface AdminService
  extends BaseService<Admin>
{
  public abstract List<Admin> findByAdmin(String paramString);
  
  public abstract void updatePSWById(String paramString1, String paramString2);
  
  public abstract Admin getById(int paramInt);
  
  public abstract List<Admin> find(int paramInt1, int paramInt2);
  
  public XSSFWorkbook export(Date startDate, Date endDate);
}