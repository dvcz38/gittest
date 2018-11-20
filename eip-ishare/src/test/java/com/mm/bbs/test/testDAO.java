package com.mm.bbs.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

 
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.mm.bbs.dao.AdminDao;
import com.mm.bbs.dao.DoorSensorDtlDao;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.pojo.MenuCode;
import com.mm.bbs.pojo.SecCode;
import com.mm.bbs.service.MenuService;
import com.mm.bbs.util.CryptographyUtil;

public class testDAO {
//Logger log = Logger.getLogger(JunitTest.class);
	
	@Resource 
	private MenuService menuService;
	
	@Autowired  
	private DoorSensorDtlDao doorSensorDao;
	@Autowired 
	private AdminDao userDao;

	
	@Test  
	public void test11() throws IOException { 
//		doorSensorDao.findEnityById(DoorSensorDtl.class, "1");
		List<DoorSensorDtl> menus = doorSensorDao.findDiviceByStaffCheckOnDate(false, new Date("2018-11-12"));
//		userDao.findAdmins();
		menuService.finds();
	  }

    @Test  
    public void test() throws IOException { 
    	

	List<MenuCode> menus = menuService.finds();
		
		if(menus != null){
			for(MenuCode menu : menus){
				
				System.out.println(menu.getSecCodes().size());
				System.out.print("菜单:"+menu.getMenuCode()+"-拥有的子菜单:");
				for (SecCode secCode : menu.getSecCodes()) {
					System.out.print(secCode.getSecCode()+",");
				}
				System.out.println();
			}
		}
    	
		Gson gson = new Gson();
		String str = gson.toJson(menus);
		System.out.println("响应后的json值:"+str);
    	
    }  
    
    
    @Test
	public void test2() {
    	System.out.println(CryptographyUtil.md5("admin", "ADMIN-10001"));
    }
	@Test
	public void test1() throws IOException  {
	List<MenuCode> menus = menuService.finds();
		
		if(menus != null){
			for(MenuCode menu : menus){
				
				System.out.println(menu.getSecCodes().size());
				System.out.print("菜单:"+menu.getMenuCode()+"-拥有的子菜单:");
				for (SecCode secCode : menu.getSecCodes()) {
					System.out.print(secCode.getSecCode()+",");
				}
				System.out.println();
			}
		}
	}
}
