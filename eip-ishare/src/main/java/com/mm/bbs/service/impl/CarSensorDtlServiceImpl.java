package com.mm.bbs.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.bbs.common.CheckState;
import com.mm.bbs.dao.CarSensorDtlDao;
import com.mm.bbs.dao.CarSensorDtlDao;
import com.mm.bbs.pojo.CarSensorDtl;
import com.mm.bbs.pojo.CarSensorDtl;
import com.mm.bbs.service.CarSensorDtlService;
@Service("carSensorDtlService")
public class CarSensorDtlServiceImpl implements CarSensorDtlService {

	private static final Logger log = Logger
			.getLogger(CarSensorDtlServiceImpl.class);
	
	@Autowired
	private CarSensorDtlDao carSensorDtlDao; 
	
	public List<CarSensorDtl> findPage(int page, int rows)
	{
	    return this.carSensorDtlDao.findPage(CarSensorDtl.class, page, rows, "inputDt", "desc");
	}
	  
	@Override
	public void save(CarSensorDtl entity) {
		// TODO Auto-generated method stub
		carSensorDtlDao.save(entity);
	}

	@Override
	public void delete(CarSensorDtl entity) {
		// TODO Auto-generated method stub
		carSensorDtlDao.delete(entity);
	}

	@Override
	public void update(CarSensorDtl entity) {
		// TODO Auto-generated method stub
		carSensorDtlDao.saveOrUpdate(entity);
	}

	@Override
	public CarSensorDtl findById(Serializable id) {
		// TODO Auto-generated method stub
		return carSensorDtlDao.getById(CarSensorDtl.class, id);
	}

	@Override
	public List<CarSensorDtl> getAll() {
		// TODO Auto-generated method stub
		return carSensorDtlDao.findAll(CarSensorDtl.class);
	}
	 
	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		CarSensorDtl entity=findById(id);
		if(entity !=null)
			this.delete(entity);
	}

	 
 
 
	@Override
	public List<CarSensorDtl> findDeviceOnCurrentDay(String deviceId, String carStatus)
	{ 
		return carSensorDtlDao.findDeviceByParams(0,deviceId, carStatus);
	}

	@Override
	public List<CarSensorDtl> findDeviceBtwDatetime(String deviceId, String carState,String fdate,String todate) {
		// TODO Auto-generated method stub
//		(String deviceId,String checkState,String carState,String fdate,String todate)
		return carSensorDtlDao.findDeviceBtwDatetime(deviceId, carState, fdate, todate);
	}
	
 
 
	/*************************************************************************************************************
	 * 
	 * 
	 */
 
	public XSSFWorkbook export(Date startDate, Date endDate) {
		String[] excelHeader = { "Input Date","ID", "Device", "Channel", "Floor", "Door Distance", "Door Status","Battery Volume","Signal Power","Staff Check","Staff Name"};
		List<CarSensorDtl> lists = getAll();
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet1 = wb.createSheet("Doorsensor Detail");
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
		CarSensorDtl ds;
		XSSFDataFormat format = wb.createDataFormat();
		style.setDataFormat(format.getFormat("yyyy-mm-dd hh:mm:ss"));
		for (int i = 0; i < lists.size(); i++) {
			row = sheet1.createRow(i + 1);
			ds = lists.get(i);
//			int state = user.getState();
			row.createCell(0).setCellValue(ds.getInputDt());
			row.createCell(1).setCellValue(ds.getId());
			row.createCell(2).setCellValue(ds.getDevice().getDeviceDesc()); 
			row.createCell(3).setCellValue(ds.getCarStatus());
			row.createCell(4).setCellValue(ds.getBattVol());
			row.createCell(5).setCellValue(ds.getNbSignalPwr()); 
			cell = row.createCell(6);
//			cell.setCellValue(sortingOrderVo.getCreateDate());
			cell.setCellStyle(style);

		}
		return wb;
	}
 
//	public List getDoorStatusCount(String inputDt) {
//		return carSensorDtlDao.getCount(inputDt);
//	}
}
