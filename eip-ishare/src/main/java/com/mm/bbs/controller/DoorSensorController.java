package com.mm.bbs.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.bbs.common.DeviceType;
import com.mm.bbs.common.DoorStatus; 
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.service.DoorSensorDtlService;
import com.mm.bbs.service.DoorSensorService;
 
import com.mm.bbs.util.CryptographyUtil;
import com.mm.bbs.util.TimeUtil;
import com.mm.bbs.vo.DoorSensorVo;
import com.mm.bbs.vo.Pagination; 
import com.mm.bbs.vo.UserVo;



@Controller
@RequestMapping("/device")
@SuppressWarnings("all")
public class DoorSensorController {
	 
	
	@Resource
	private DoorSensorService doorSensorService;
	
 
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String listPage() {

		return "/view/device/device";
	}
	
	@RequestMapping(value = "/list1.do", method = RequestMethod.GET)
	public String listPage1() {

		return "/view/device/device1";
	}
	
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	@ResponseBody
	public String delete(DoorSensor ds)
		    throws IOException
	{
		this.doorSensorService.delete(ds);
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
		        this.doorSensorService.deleteById(Integer.valueOf(Integer.parseInt(id)));
		      }
		    }
		    return "success";
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	@ResponseBody
	public String update(DoorSensorVo entity) 
	{
		DoorSensor ds = (DoorSensor)this.doorSensorService.findById(Integer.valueOf(entity.getId()));
		ds.setChannelNo(Integer.parseInt(entity.getChannelNo()));
		ds.setDeviceDesc(entity.getDeviceDesc());
		ds.setFloorNo(Integer.parseInt(entity.getFloorNo())); 
		try {
			ds.setInstalDt(TimeUtil.convertDate(entity.getInstalDt()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds.setState(entity.getState()); 
		this.doorSensorService.update(ds);
		return "success"; 
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(DoorSensorVo entity)
		    throws IOException
	{
		
				//entity.getPojo();
		if ( entity != null )
	    { 
			DoorSensor ds=new DoorSensor();
			ds.setDeviceDesc(entity.getDeviceDesc());
			ds.setChannelNo(Integer.parseInt(entity.getChannelNo()));
			ds.setFloorNo(Integer.parseInt(entity.getFloorNo()));
			try {
				ds.setInstalDt(TimeUtil.convertDate(entity.getInstalDt()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ds.setState(entity.getState());
		    this.doorSensorService.save(ds);
		    return "success";
	    } 
	    return "fail";
	}
	/*
	 * DoorSensor
	 */
	@RequestMapping(value = "/getall.do")
	@ResponseBody
	public Map<String,Object> getAll(){
		
		List<DoorSensor> lst = doorSensorService.getAll();

		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/getalldoorsensor.do")
	@ResponseBody
	public Map<String,Object> getDoorSensor(){
		
		List<DoorSensor> lst = doorSensorService.findDoorSensor(null, null, null, null, null, DeviceType.DOOR.getValue());

		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/getchannel.do")
	@ResponseBody
	public Map<String,Object> getChannel(){
		//
		List<String> lst = doorSensorService.getChannel();

		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	  
	@RequestMapping(value = "/export.do",method = RequestMethod.GET)
    public void exportSortingOrder(HttpServletRequest request,HttpServletResponse response) throws IOException{
//    	String parttern = DateUtil.DATETIME_FORMAT;
//    	Date startDate = DateUtil.StringToDate(request.getParameter("startDate"), parttern);
//    	Date endDate = DateUtil.StringToDate(request.getParameter("endDate"), parttern);
    	XSSFWorkbook wb = doorSensorService.export(null, null);        
//        String[] sds = request.getParameter("startDate").split("\\s");
//        String[] eds = request.getParameter("endDate").split("\\s");
        StringBuffer fileName=new StringBuffer("attachment;filename=");
        fileName.append(new Date().getTime()).append(".xlsx");  
//        fileName.append(sds[0]).append("_").append(eds[0]).append("_").append(new Date().getTime()).append(".xlsx");        
        response.setContentType("application/ms-excel");
        response.setHeader("Content-disposition",fileName.toString());
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();   	
    	
    }
    
	 @CrossOrigin(origins = "*", maxAge = 3600)
	 @RequestMapping(value="/json.do",produces="application/json;charset=utf-8")
	 @ResponseBody
	 public  Map<String,Object> jsontest(@RequestBody Map<String,Object> map,HttpServletRequest request, HttpServletResponse response) {
	        response.addHeader("Access-Control-Allow-Origin", "*");

	        map =new LinkedHashMap<String,Object>();
			map.put("total", 2);
			map.put("rows", null); 
			return map; 
	    }
}
