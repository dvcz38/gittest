package com.mm.bbs.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mm.bbs.common.DoorStatus;
import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.service.DoorSensorDtlService;
import com.mm.bbs.util.TimeUtil;
import com.mm.bbs.vo.DoorSensorDtlVo;

@Controller
@RequestMapping("/device/dtl")
@SuppressWarnings("all")
public class DoorSensorDtlController {

	@Resource
	private DoorSensorDtlService doorSensorDtlService;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String doorsensorlistPage() {

		return "/view/device/doorsensordtl";
	}
	
	@RequestMapping(value = "/dtllist.do", method = RequestMethod.GET)
	public String devicedtllistPage() {

		return "/view/device/devicedtl";
	}
	 
	 
	@RequestMapping(value = "/add.do",method = RequestMethod.POST)
	@ResponseBody
	public void save(DoorSensorDtlVo entity){
		
		entity=new DoorSensorDtlVo();
		entity.setBattVol((float) -9.99);
		entity.setDeviceId("1");
		entity.setDoorStatus("Close");
		entity.setDoorDistance(10);
		entity.setInputDt("2018-12-15 11:18:00");
		entity.setNbSignalPwr((float) -98.2);
		
		//
		DoorSensor ds=new DoorSensor();
		ds.setId(entity.getDeviceId());
//		ds.setDeviceDesc(entity.getDeviceDesc());
//		ds.setChannelNo(Integer.parseInt(entity.getChannelNo()));
//		ds.setFloorNo(Integer.parseInt(entity.getFloorNo()));
		
		DoorSensorDtl dtl=new DoorSensorDtl();
		dtl.setBattVol(entity.getBattVol());
		dtl.setDoorStatus(entity.getDoorStatus());
		dtl.setDevice(ds);
		dtl.setDoorDistance(entity.getDoorDistance());
		try {
			dtl.setInputDt(TimeUtil.convertDateTime(entity.getInputDt()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dtl.setNbSignalPwr(entity.getNbSignalPwr());
		doorSensorDtlService.save(dtl); 
		
		
//		DoorSensorDtl entity=new DoorSensorDtl();
//		DoorSensor ds=new DoorSensor();
//		ds.setId(1);
//		entity.setBattVol((float) 4.32);
//		entity.setDoorStatus("Open");
//		entity.setDevice(ds);
//		entity.setDoorDistance(24);
//		entity.setInputDt(new Date());
//		entity.setNbSignalPwr(-98);
//		doorSensorDtlService.save(dtl);
		
 
	}
 
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	@ResponseBody
	public String update(DoorSensorDtlVo entity) throws IOException{

	    /* 逻辑代码 */
		
		DoorSensorDtl dtl = doorSensorDtlService.findById(entity.getId());
				//.findById(Integer.valueOf(entity.getId()));
 
//		DoorSensor ds=new DoorSensor();
//		ds.setId(Integer.parseInt(entity.getDeviceId()));
//		ds.setDeviceDesc(entity.getDeviceDesc());
//		ds.setChannelNo(Integer.parseInt(entity.getChannelNo()));
//		ds.setFloorNo(Integer.parseInt(entity.getFloorNo()));
		
		dtl.setBattVol(entity.getBattVol());
		dtl.setDoorStatus(entity.getDoorStatus());
//		dtl.setDevice(ds);
		dtl.setDoorDistance(entity.getDoorDistance());
		try {
			dtl.setInputDt(TimeUtil.convertDateTime(entity.getInputDt()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dtl.setIsStaffCheck(entity.getIsStaffCheck());
		dtl.setStaffno(entity.getStaffno());
		dtl.setNbSignalPwr(entity.getNbSignalPwr());
		doorSensorDtlService.update(dtl);
		
		return "success";  
	}
	
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	@ResponseBody
	public String delete(String id) throws IOException{
 
		this.doorSensorDtlService.deleteById(Integer.valueOf(Integer.parseInt(id)));
	    return "success";
	}
	
	@RequestMapping(value = "deletelist.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteList(String ids)
		    throws IOException
	{
		    if ((ids != null) && (ids.length() > 0))
		    {
		      String[] lst = ids.split("\\,");
		      String[] arrayOfString1;
		      int j = (arrayOfString1 = lst).length;
		      for (int i = 0; i < j; i++)
		      {
		        String id = arrayOfString1[i];
		        this.doorSensorDtlService.deleteById(Integer.valueOf(Integer.parseInt(id)));
		      }
		    }
		    return "success";
	}
	
	/*
	 * DoorSensor Detail
	 * 
	 */
	@RequestMapping(value = "/getall.do")
	@ResponseBody
	public Map<String,Object> getAll(){
		//
		List<DoorSensorDtl> lst = doorSensorDtlService.getAll();
 
 
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	 
	@RequestMapping(value = "/getclose.do",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getDeviceofDoorClose(){
		
		String inputDt=TimeUtil.getDateTime();
		List<DoorSensorDtl> lst = doorSensorDtlService.findDeviceOnDatetime(inputDt,null, null, 0, DoorStatus.DOOR_CLOSE.getValue());

		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/getopenclose.do",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getDeviceofDoorOpen(){
		//use system date
		String inputDt=TimeUtil.getDateTime();
		System.out.println("input DATETIME===>"+inputDt);
		List lst = doorSensorDtlService.getDoorStatusCount(inputDt);
//				.findDeviceOnDatetime(inputDt, null, 0, DoorStatus.DOOR_OPEN.getValue());
//		List<DoorSensorDtl> lst1 = doorSensorDtlService.findDeviceOnDatetime(inputDt, null, 0, DoorStatus.DOOR_CLOSE.getValue());

		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
//		map.put("close", lst1.size()); 
		return map;
	}
	
	@RequestMapping(value = "/getdevice.do")
	@ResponseBody
	public Map<String,Object> findCurrentDayDevices(String deviceId){
		 String inputDt=TimeUtil.getDateTime();
		 List<DoorSensorDtl> lst=doorSensorDtlService.findDeviceOnDatetime(inputDt,deviceId, null, 0, DoorStatus.DOOR_OPEN.getValue());
 
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		 return map; 
	}
	
	@RequestMapping(value = "/search.do")
	@ResponseBody
	public Map<String,Object> search(String deviceId,String fdate, String todate){
//		 String inputDt=TimeUtil.getDateTime();
//		 deviceId="4";
//		 fdate="2018-12-13 04:00:00";
//		 todate="2018-12-13 12:00:00";
		 List<DoorSensorDtl> lst=doorSensorDtlService.findDeviceBtwDatetime(deviceId, null, null, fdate, todate);
		 //.findDeviceOnDatetime(inputDt,deviceId, null, 0, DoorStatus.DOOR_OPEN.getValue());
 
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		 return map; 
	}
	
	@RequestMapping(value = "/findautocheck.do")
	@ResponseBody
	public Map<String,Object> findCurrentAutoCheckDevices(){
		 
		List<DoorSensorDtl> lst=doorSensorDtlService.findAutoCheckDeviceOnHour( 0, DoorStatus.DOOR_OPEN.getValue());
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		 return map; 
	}
	
	@RequestMapping(value = "/findmanulcheck.do")
	@ResponseBody
	public Map<String,Object> findCurrentManulCheckDevices(){
		 
		 List<DoorSensorDtl> lst=doorSensorDtlService.findManulCheckDeviceOnCurrentDay(0, DoorStatus.DOOR_OPEN.getValue());
 
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		 return map;
//		return null;
	}
	
	
	@RequestMapping({"/findpage.do"})
	@ResponseBody
	public Map<String, Object> findpage(int page, int rows)
	{
	    List<DoorSensorDtl> lst = this.doorSensorDtlService.findPage(page, rows);
	    
	    Map<String, Object> map = new LinkedHashMap();
	    map.put("total", Integer.valueOf(lst.size()));
	    map.put("rows", lst);
	    return map;
	}
	
	@RequestMapping(value = "/export.do",method = RequestMethod.GET)
    public void exportSortingOrder(HttpServletRequest request,HttpServletResponse response) throws IOException{
//    	String parttern = DateUtil.DATETIME_FORMAT;
//    	Date startDate = DateUtil.StringToDate(request.getParameter("startDate"), parttern);
//    	Date endDate = DateUtil.StringToDate(request.getParameter("endDate"), parttern);
    	XSSFWorkbook wb = doorSensorDtlService.export(null, null);    
        StringBuffer fileName=new StringBuffer("attachment;filename=");
        fileName.append(new Date().getTime()).append(".xlsx");          
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition",fileName.toString());
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();   	
    	
    }
}
