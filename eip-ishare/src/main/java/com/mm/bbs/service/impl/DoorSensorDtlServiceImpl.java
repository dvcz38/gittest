package com.mm.bbs.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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
import com.mm.bbs.dao.DoorSensorDtlDao;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.pojo.DoorSensorDtl; 
import com.mm.bbs.service.DoorSensorDtlService;

@Service("doorSensorDtlService")
public class DoorSensorDtlServiceImpl implements DoorSensorDtlService {
	
	private static final Logger log = Logger
			.getLogger(DoorSensorDtlServiceImpl.class);
	
	@Autowired
	private DoorSensorDtlDao doorSensorDtlDao; 
	public List<DoorSensorDtl> findPage(int page, int rows)
	{
	    return this.doorSensorDtlDao.findPage(DoorSensorDtl.class, page, rows, "inputDt", "desc");
	}
	  
	@Override
	public void save(DoorSensorDtl entity) {
		// TODO Auto-generated method stub
		doorSensorDtlDao.save(entity);
	}

	@Override
	public void delete(DoorSensorDtl entity) {
		// TODO Auto-generated method stub
		doorSensorDtlDao.delete(entity);
	}

	@Override
	public void update(DoorSensorDtl entity) {
		// TODO Auto-generated method stub
		doorSensorDtlDao.saveOrUpdate(entity);
	}

	@Override
	public DoorSensorDtl findById(Serializable id) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.getById(DoorSensorDtl.class, id);
	}

	@Override
	public List<DoorSensorDtl> getAll() {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findAll(DoorSensorDtl.class);
	}
	 
	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		DoorSensorDtl entity=findById(id);
		if(entity !=null)
			this.delete(entity);
	}

	@Override
	public List<DoorSensorDtl> findDeviceByInd(Integer i) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDeviceByInd(i);
	}

	@Override
	public List<DoorSensorDtl> findDeviceByChnlNo(Integer i, Integer channelNo) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDeviceByChnlNo(i, channelNo);
	}
//	@Override
//	public List<DoorSensorDtl> findDeviceByStaffCheckOnDate(boolean staffCheckInd, String fdate) {
//		// TODO Auto-generated method stub
//		return doorSensorDtlDao.(staffCheckInd, fdate);
//	}
	
	public List<DoorSensorDtl> findDeviceOnCurrentDay(Integer channelNo,String deviceId, String checkState,String doorStatus)
	{ 
		return doorSensorDtlDao.findDeviceByParams(0,deviceId,checkState, channelNo, doorStatus);
	}

	@Override
	public List<DoorSensorDtl> findDeviceBtwDatetime(String deviceId,String checkState,String doorState,String fdate,String todate) {
		// TODO Auto-generated method stub
//		(String deviceId,String checkState,String doorState,String fdate,String todate)
		return doorSensorDtlDao.findDeviceBtwDatetime(deviceId, checkState, doorState, fdate, todate);
	}
	
	@Override
	public List<DoorSensorDtl> findDeviceOnDatetime(String inputDt,String deviceId, String checkState, Integer channelNo, String doorStatus)
	{
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDeviceByParams(inputDt,deviceId, checkState, channelNo, doorStatus);
	}
	public List<DoorSensorDtl> findManulCheckDeviceOnCurrentDay(Integer channelNo, String doorStatus){
		
		return doorSensorDtlDao.findDeviceByParams(0,CheckState.Manulcheck.getValue(), channelNo, doorStatus);
	}
	/*************************************************************************************************************
	 * 
	 * 
	 */
	@Override
	public List<DoorSensorDtl> findAutoCheckDeviceOnHour(Integer channelNo, String doorStatus) {
		// TODO Auto-generated method stub
		return doorSensorDtlDao.findDeviceByParamsOnHour(CheckState.Autocheck.getValue(), channelNo, doorStatus);
	}
	public XSSFWorkbook export(Date startDate, Date endDate) {
		String[] excelHeader = { "Input Date","ID", "Device", "Channel", "Floor", "Door Distance", "Door Status","Battery Volume","Signal Power","Staff Check","Staff Name"};
		List<DoorSensorDtl> lists = getAll();
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
		DoorSensorDtl ds;
		XSSFDataFormat format = wb.createDataFormat();
		style.setDataFormat(format.getFormat("yyyy-mm-dd hh:mm:ss"));
		for (int i = 0; i < lists.size(); i++) {
			row = sheet1.createRow(i + 1);
			ds = lists.get(i);
//			int state = user.getState();
			row.createCell(0).setCellValue(ds.getInputDt());
			row.createCell(1).setCellValue(ds.getId());
			row.createCell(2).setCellValue(ds.getDevice().getDeviceDesc());
			row.createCell(3).setCellValue(ds.getDevice().getChannelNo());
			row.createCell(4).setCellValue(ds.getDevice().getFloorNo());
			row.createCell(5).setCellValue(ds.getDoorDistance());
			row.createCell(6).setCellValue(ds.getDoorStatus());
			row.createCell(7).setCellValue(ds.getBattVol());
			row.createCell(8).setCellValue(ds.getNbSignalPwr());
			row.createCell(9).setCellValue(ds.getIsStaffCheck());
			row.createCell(10).setCellValue(ds.getStaffno());
			cell = row.createCell(11);
//			cell.setCellValue(sortingOrderVo.getCreateDate());
			cell.setCellStyle(style);

		}
		return wb;
	}
 
	public List getDoorStatusCount(String inputDt) {
		return doorSensorDtlDao.getCount(inputDt);
	}
	
}
