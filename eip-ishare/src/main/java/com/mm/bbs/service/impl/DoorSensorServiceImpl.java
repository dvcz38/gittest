package com.mm.bbs.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.bbs.dao.DoorSensorDao;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.pojo.DoorSensor; 
import com.mm.bbs.service.DoorSensorService;

@Service("doorSensorService")
public class DoorSensorServiceImpl implements DoorSensorService {

	
	@Autowired
	private DoorSensorDao doorSensorDao;
	@Override
	public void save(DoorSensor entity) {
		// TODO Auto-generated method stub
		doorSensorDao.save(entity);
	}

	@Override
	public void delete(DoorSensor entity) {
		// TODO Auto-generated method stub
		doorSensorDao.delete(entity);
		
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		DoorSensor entity = findById(id);
	    if (entity != null) {
	      this.delete(entity);
	    } 
	}

	@Override
	public void update(DoorSensor entity) {
		// TODO Auto-generated method stub
		doorSensorDao.update(entity);
	}

	@Override
	public DoorSensor findById(Serializable id) {
		// TODO Auto-generated method stub
		return doorSensorDao.getById(DoorSensor.class, id);
	}

	@Override
	public List<DoorSensor> getAll() {
		// TODO Auto-generated method stub
		return doorSensorDao.findAll(DoorSensor.class);
	}

	@Override
	public List<DoorSensor> findDoorSensor(String deviceId, String deviceDesc, String channelNo, String floorNo,
			String state,String type) {
		// TODO Auto-generated method stub
		return doorSensorDao.findDoorSensor(deviceId, deviceDesc, channelNo, floorNo, state,type);
	}

	@Override
	public List<String> getChannel() {
		// TODO Auto-generated method stub
		return doorSensorDao.getDoorChannel();
	}
	@Override
	public XSSFWorkbook export(Date startDate, Date endDate) {
		String[] excelHeader = { "ID", "Device", "Channel", "Floor","State","Instal Date"};
		List<DoorSensor> lists = getAll();
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet1 = wb.createSheet("Doorsensor");
		// 设置style
		XSSFCellStyle headStyle = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 23);
		headStyle.setFont(font); 
		XSSFCellStyle style = wb.createCellStyle(); 
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
		DoorSensor ds;
		XSSFDataFormat format = wb.createDataFormat();
		style.setDataFormat(format.getFormat("yyyy-mm-dd hh:mm:ss"));
		for (int i = 0; i < lists.size(); i++) {
			row = sheet1.createRow(i + 1);
			ds = lists.get(i); 
			row.createCell(0).setCellValue(ds.getId());
			row.createCell(1).setCellValue(ds.getDeviceDesc());
			row.createCell(2).setCellValue(ds.getChannelNo());
			row.createCell(3).setCellValue(ds.getFloorNo());
			row.createCell(4).setCellValue(ds.getState());
			row.createCell(5).setCellValue(ds.getInstalDt()); 
			cell = row.createCell(6); 
			cell.setCellStyle(style);

		}
		return wb;
	}
}
