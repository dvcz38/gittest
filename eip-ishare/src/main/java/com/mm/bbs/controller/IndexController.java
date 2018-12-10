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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mm.bbs.pojo.Admin;
import com.mm.bbs.service.AdminService;
import com.mm.bbs.service.MenuService;
import com.mm.bbs.util.CryptographyUtil;
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
//		return "/view/assetsPage/update_psw";
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
	public String managerPage() {

		return "/view/pages/pagemanager";
	}
	
	 

	@RequestMapping({"/findpage.do"})
	@ResponseBody
	public Map<String, Object> findUser(int page, int rows)
	{
	    List<Admin> lst = this.userService.find(page, rows);
	    
	    Map<String, Object> map = new LinkedHashMap();
	    map.put("total", Integer.valueOf(lst.size()));
	    map.put("rows", lst);
	    return map;
	}
	  
	@RequestMapping({"/findall.do"})
	@ResponseBody
	public Map<String, Object> findAll()
	{
	    List<Admin> lst = this.userService.getAll();
	    
	    Map<String, Object> map = new LinkedHashMap();
	    map.put("total", Integer.valueOf(lst.size()));
	    map.put("rows", lst);
	    return map;
	}
	  
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	@ResponseBody
	public String delete(Admin user)
		    throws IOException
	{
		this.userService.delete(user);
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
		        this.userService.deleteById(Integer.valueOf(Integer.parseInt(id)));
		      }
		    }
		    return "success";
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	@ResponseBody
	public String update(UserVo user)
		    throws IOException
	{
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    try
		    {
		      Date joindate = (Date)formatter.parseObject(user.getJoindate());
		      Admin admin = (Admin)this.userService.findById(Integer.valueOf(user.getId()));
		      admin.setEmail(user.getEmail());
		      admin.setName(user.getName());
		      admin.setPassword(user.getPassword());
		      admin.setPhone(user.getPhone());
		      admin.setState(user.getState());
		      admin.setRole(user.getRole());
		      admin.setJoindate(joindate);
		      this.userService.update(admin);
		      return "success";
		    }
		    catch (ParseException e)
		    {
		      e.printStackTrace();
		    }
		    return null;
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(UserVo user)
		    throws IOException
	{
		Admin usr=user.getPojo();
		if ((user != null) && (usr != null))
	    {
	    	String pws=CryptographyUtil.md5(user.getPassword(), "ADMIN-10001");
	    	usr.setPassword(pws);
		    this.userService.save(usr);
		    return "success";
	    }
	    return "fail";
	}
	
	@RequestMapping(value = "/export.do",method = RequestMethod.GET)
    public void exportSortingOrder(HttpServletRequest request,HttpServletResponse response) throws IOException{
//    	String parttern = DateUtil.DATETIME_FORMAT;
//    	Date startDate = DateUtil.StringToDate(request.getParameter("startDate"), parttern);
//    	Date endDate = DateUtil.StringToDate(request.getParameter("endDate"), parttern);
    	XSSFWorkbook wb = userService.export(null, null);        
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

	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String testdata() {

		return "/view/admin/user/test";
	}
}
