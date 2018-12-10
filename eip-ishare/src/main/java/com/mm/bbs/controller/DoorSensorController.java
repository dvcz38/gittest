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
import com.mm.bbs.modelVo.MenuCodeVo;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.pojo.MenuCode;
import com.mm.bbs.pojo.SecCode;
import com.mm.bbs.service.DoorSensorDtlService;
import com.mm.bbs.service.DoorSensorService;
import com.mm.bbs.service.MenuService;
import com.mm.bbs.util.CryptographyUtil;
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
	
 
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String listPage() {

		return "/view/device/device";
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
	public String update(DoorSensor doorSensor) 
	{
//		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    //		      Date joindate = (Date)formatter.parseObject(user.getJoindate());
					      DoorSensor ds = (DoorSensor)this.doorSensorService.findById(Integer.valueOf(doorSensor.getId()));
			//		      ds.setChannelNo(channelNo);
			//		      ds.setDeviceDesc(deviceDesc);
			//		      ds.setFloorNo(floorNo);
			//		      ds.setInstalDt(instalDt);
			//		      ds.setState(state); 
					      this.doorSensorService.update(doorSensor);
					      return "success";
//		    return null;
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(DoorSensor doorSensor)
		    throws IOException
	{
//		Admin usr=user.getPojo();
//		if ((user != null) && (usr != null))
//	    {
//	    	String pws=CryptographyUtil.md5(user.getPassword(), "ADMIN-10001");
//	    	usr.setPassword(pws);
//		    this.userService.save(usr);
//		    return "success";
//	    }
	    return "fail";
	}
	/*
	 * DoorSensor
	 */
	@RequestMapping(value = "/getall.do")
	@ResponseBody
	public Map<String,Object> getAll(){
		//
		List<DoorSensor> lst = doorSensorService.getAll();

		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/getchanel.do")
	@ResponseBody
	public Map<String,Object> getChannel(){
		//
		List<DoorSensor> lst = doorSensorService.getChannel();

		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/getall.do",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getDeviceAll(){
		 
		List<DoorSensor> lst = doorSensorService.getAll();
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
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
