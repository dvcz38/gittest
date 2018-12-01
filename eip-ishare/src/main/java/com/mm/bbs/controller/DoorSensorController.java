package com.mm.bbs.controller;

import java.io.IOException;
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
import com.mm.bbs.modelVo.MenuCodeVo;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.pojo.MenuCode;
import com.mm.bbs.pojo.SecCode;
import com.mm.bbs.service.DoorSensorDtlService;
import com.mm.bbs.service.DoorSensorService;
import com.mm.bbs.service.MenuService;
import com.mm.bbs.util.DoorStatus;
import com.mm.bbs.util.TimeUtil; 
import com.mm.bbs.vo.Pagination;
import com.mm.bbs.vo.TreeDataVo;
import com.mm.bbs.vo.UserVo;



@Controller
@RequestMapping("/device")
@SuppressWarnings("all")
public class DoorSensorController {
	 
	
	@Resource
	private DoorSensorService doorSensorService;
	

	@Resource
	private DoorSensorDtlService doorSensorDtlService;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String listPage() {

		return "/view/device/device";
	}
	/*
	 * DoorSensor
	 */
	@RequestMapping(value = "/getalldevice.do")
	@ResponseBody
	public Map<String,Object> getAllDevice(){
		//
		List<DoorSensor> lst = doorSensorService.getAll();

		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	/*
	 * DoorSensor Detail
	 * 
	 */
	@RequestMapping(value = "/getalldtl.do")
	@ResponseBody
	public Map<String,Object> getAll(){
		//
		List<DoorSensorDtl> lst = doorSensorDtlService.getAll();
 
 
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/getall.do",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getDeviceAll(){
		 
//		return doorSensorService.getAll().size();
		List<DoorSensor> lst = doorSensorService.getAll();
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/getlose.do",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getDeviceCountLose(){
		//
		Long i=(long) 0;
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
		List<DoorSensorDtl> lst = doorSensorDtlService.findDeviceOnDatetime(inputDt, null, 0, DoorStatus.DOOR_CLOSE.getValue());

		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/getopen.do",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getDeviceofDoorOpen(){
		//
		String inputDt=TimeUtil.getDateTime();
		List<DoorSensorDtl> lst = doorSensorDtlService.findDeviceOnDatetime(inputDt, null, 0, DoorStatus.DOOR_OPEN.getValue());

		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/findautocheckontime.do")
	@ResponseBody
	public Map<String,Object> findCurrentDayDevices(){
		
		 List<DoorSensorDtl> lst=doorSensorDtlService.findAutoCheckDeviceOnHour(0, null);
 
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		 return map; 
	}
	
	@RequestMapping(value = "/findautocheck.do")
	@ResponseBody
	public Map<String,Object> findCurrentAutoCheckDevices(){
		 
		List<DoorSensorDtl> lst=doorSensorDtlService.findAutoCheckDeviceOnHour( 0, null);
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		 return map; 
	}
	
	@RequestMapping(value = "/findmanulcheck.do")
	@ResponseBody
	public Map<String,Object> findCurrentManulCheckDevices(){
		 
		 List<DoorSensorDtl> lst=doorSensorDtlService.findManulCheckDeviceOnCurrentDay(0, null);
 
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		 return map;
//		return null;
	}
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	@ResponseBody
	public String update(@RequestBody String id) throws IOException{

	    /* 逻辑代码 */
		doorSensorDtlService.update(null); 
	    return "success";
	}
	@RequestMapping(value = "delete.do", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestBody String id) throws IOException{

	    /* 逻辑代码 */
		doorSensorDtlService.delete(null);
	    return "success";
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
