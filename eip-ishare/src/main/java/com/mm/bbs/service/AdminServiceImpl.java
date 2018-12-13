package com.mm.bbs.service;

import com.mm.bbs.dao.AdminDao;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.util.CryptographyUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
  
  
  public XSSFWorkbook export(Date startDate, Date endDate) {
		String[] excelHeader = { "ID", "User Name", "Email", "Phone", "Role", "State"};
		List<Admin> lists = getAll();
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet1 = wb.createSheet("USER INFO");
		// 设置style
		XSSFCellStyle headStyle = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 23);
		headStyle.setFont(font);
//		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		XSSFCellStyle style = wb.createCellStyle();
//		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		for (int i = 0; i < excelHeader.length; i++) {
			sheet1.setDefaultColumnStyle(i, style);
		}
		XSSFRow row0 = sheet1.createRow(0);
		for (int i = 0; i < excelHeader.length; i++) {
			XSSFCell cell = row0.createCell(i);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			sheet1.setColumnWidth(i, 5000);
		}
		XSSFRow row;
		XSSFCell cell;
		Admin user;
		XSSFDataFormat format = wb.createDataFormat();
		style.setDataFormat(format.getFormat("yyyy-mm-dd hh:mm:ss"));
		for (int i = 0; i < lists.size(); i++) {
			row = sheet1.createRow(i + 1);
			user = lists.get(i);
//			int state = user.getState();
			row.createCell(0).setCellValue(user.getId());
			row.createCell(1).setCellValue(user.getName());
			row.createCell(2).setCellValue(user.getPhone());
			row.createCell(3).setCellValue(user.getEmail());
			row.createCell(4).setCellValue(user.getRole());
			row.createCell(5).setCellValue(user.getState());
			cell = row.createCell(6);
//			cell.setCellValue(sortingOrderVo.getCreateDate());
			cell.setCellStyle(style);

		}
		return wb;
	}

}
