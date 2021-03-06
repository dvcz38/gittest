package com.mm.bbs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mm.bbs.pojo.AcctAuthority;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.service.AcctAuthorityService;
import com.mm.bbs.service.DoorSensorDtlService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/role")
@SuppressWarnings("all")
public class AcctAuthorityController {

	@Resource
	private AcctAuthorityService acctAuthorityService;
	
	
	@RequestMapping(value = "/rolelist.do", method = RequestMethod.GET)
	public String roleListPage() {

		return "/view/admin/user/rolelist";
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String rolePage() {

		return "/view/admin/user/role";
	}
	
	@RequestMapping(value = "/getall.do")
	@ResponseBody
	public Map<String,Object> getAll(){
		//
		List<AcctAuthority> lst = acctAuthorityService.getAll();
 
 
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "delete.do", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(AcctAuthority user) throws IOException{

	    /* 逻辑代码 */ 
		acctAuthorityService.delete(user);
	    return "success";
	}
	
	@RequestMapping(value = "deletelist.do", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteList(String ids) throws IOException{

	    /* 逻辑代码 */ 
		
		acctAuthorityService.deleteById(ids);
	    return "success";
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	@ResponseBody
	public String update(AcctAuthority role) throws IOException{

	    /* 逻辑代码 */ 
		if(role!=null)
			role.setUpdateDt(new Date());
		acctAuthorityService.update(role);
	    return "success";
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(AcctAuthority user) throws IOException{
 
	    /* 逻辑代码 */ 
		acctAuthorityService.save(user);
	    return "success";
	}
	
	@RequestMapping({"/findpage.do"})
	@ResponseBody
	public Map<String, Object> findPage(int page, int rows)
	{
	    List<AcctAuthority> lst = this.acctAuthorityService.findPage(page, rows);
	    
	    Map<String, Object> map = new LinkedHashMap();
	    map.put("total", Integer.valueOf(lst.size()));
	    map.put("rows", lst);
	    return map;
	}
}
