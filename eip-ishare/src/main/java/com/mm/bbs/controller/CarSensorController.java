package com.mm.bbs.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mm.bbs.pojo.CarSensorDtl;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.service.CarSensorDtlService;
import com.mm.bbs.service.DoorSensorDtlService;

@Controller
@RequestMapping("/carsensor/dtl")
@SuppressWarnings("all")
public class CarSensorController {
	@Resource
	private CarSensorDtlService carSensorDtlService;
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String carsensorlistPage() {

		return "/view/device/carsensordtl";
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
		        this.carSensorDtlService.deleteById(Integer.valueOf(Integer.parseInt(id)));
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
		List<CarSensorDtl> lst = carSensorDtlService.getAll();
 
 
		Map<String,Object> map=new LinkedHashMap<String,Object>();
		map.put("total", lst.size());
		map.put("rows", lst); 
		return map;
	}
}
