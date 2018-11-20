package com.mm.bbs.controller;

import java.io.IOException;
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
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.pojo.MenuCode;
import com.mm.bbs.pojo.SecCode;
import com.mm.bbs.service.DoorSensorDtlService;
import com.mm.bbs.service.MenuService;
import com.mm.bbs.vo.DoorSensorDtlVo;
import com.mm.bbs.vo.Pagination;
import com.mm.bbs.vo.TreeDataVo;
import com.mm.bbs.vo.UserVo;



@Controller
@RequestMapping("/device")
@SuppressWarnings("all")
public class DoorSensorController {
	 
	
	@Resource
	private DoorSensorDtlService doorSensorDtlService;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String listPage() {

		return "/view/device/device";
	}
 
	@RequestMapping(value = "/find.do",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> findAll(){
		//
		List<DoorSensorDtl> lst = doorSensorDtlService.getAll();
		//.findDiviceByStaffCheckOnDate(false, new Date("2018-11-12"));
				//.findDiviceByStaffCheck(false, fdate, todate)	
		List<DoorSensorDtlVo> lstVo =new ArrayList<DoorSensorDtlVo>();
		DoorSensorDtlVo dsVo= new DoorSensorDtlVo();
		dsVo.setId(1);
		dsVo.setDeviceDesc("deviceDesc");
		dsVo.setDeviceId("1");
		int i=0;
		for(DoorSensorDtl ds:lst) {
//			DoorSensorDtlVo dsVo=new DoorSensorDtlVo(ds);
//			lstVo.add(dsVo);
			i++;
			if(i==1)
				break;
		}
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lstVo.size());
		 map.put("rows", lstVo); 
		return map;
	}
	
	
	@RequestMapping(value = "/findautocheck.do")
	@ResponseBody
	public Map<String,Object> findCurrentAutoCheckDevices(){
		 
		 List<DoorSensorDtl> lst=doorSensorDtlService.findDiviceByStaffCheckOnDate(false, new Date());
 
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/findmanulcheck.do")
	@ResponseBody
	public Map<String,Object> findCurrentManulCheckDevices(){
		 
		 List<DoorSensorDtl> lst=doorSensorDtlService.findDiviceByStaffCheckOnDate(false, new Date());
 
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		return map;
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	@ResponseBody
	public String update(@RequestBody String id) throws IOException{

	    /* 逻辑代码 */
		doorSensorDtlService.update(null); 
	    return "success";
	}
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestBody String id) throws IOException{

	    /* 逻辑代码 */
		doorSensorDtlService.delete(null);
	    return "success";
	}
}
