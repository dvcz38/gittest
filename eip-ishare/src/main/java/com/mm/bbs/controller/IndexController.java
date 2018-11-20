package com.mm.bbs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mm.bbs.pojo.Admin;
import com.mm.bbs.service.AdminService;
import com.mm.bbs.service.MenuService;
import com.mm.bbs.vo.BaseDataVo;
import com.mm.bbs.vo.Pagination;
import com.mm.bbs.vo.UserVo;

@Controller
@RequestMapping("/index")
@SuppressWarnings("all")
public class IndexController {
	
	@Resource
	private AdminService userService;
 
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String indexPage() {

		return "/view/assetsPage/index";
	}
	
	@RequestMapping(value = "/userlist.do", method = RequestMethod.GET)
	public String userPage() {

		return "/view/admin/user/userList";
	}
	
	@RequestMapping(value = "/user.do", method = RequestMethod.GET)
	public String user1() {

		return "/view/admin/user/user";
	}
	
	@RequestMapping(value = "/usersetpsw.do", method = RequestMethod.GET)
	public String updatePwdPage() {

		return "/view/assetsPage/update_psw";
	}
	
	@RequestMapping(value = "/pagemanager.do", method = RequestMethod.GET)
	public String pagemanagerPage() {

		return "/view/pages/pagemanager";
	}
	
	@RequestMapping(value = "/finduser.do")
	@ResponseBody
	public Map<String,Object> findAllUser(){
		  
		 List<Admin> lst=userService.getAll();
 
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "/findall.do")
	@ResponseBody
	public Map<String,Object> findAll(){
		 
		 
		 List<Admin> lst=userService.getAll();
 
		 Map<String,Object> map=new LinkedHashMap<String,Object>();
		 map.put("total", lst.size());
		 map.put("rows", lst); 
		return map;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestBody String id) throws IOException{

	    /* 逻辑代码 */
//		doorSensorDtlService
	    return "success";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	@ResponseBody
	public String update(@RequestBody String id) throws IOException{

	    /* 逻辑代码 */
//		doorSensorDtlService
		userService.update(null);
	    return "success";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	@ResponseBody
	public String add(@RequestBody String id) throws IOException{

	    /* 逻辑代码 */
//		doorSensorDtlService
		userService.save(null);
	    return "success";
	}
	
	@RequestMapping(value = "/testdata.do", method = RequestMethod.GET)
	public String testdata() {

		return "/view/admin/user/testdata";
	}
}
