package com.mm.bbs.test;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mm.bbs.dao.AcctAuthorityDao;
import com.mm.bbs.dao.AdminDao;
import com.mm.bbs.dao.DoorSensorDtlDao;
import com.mm.bbs.pojo.AcctAuthority;
import com.mm.bbs.service.AcctAuthorityService;
import com.mm.bbs.service.AdminService;
import com.mm.bbs.service.DoorSensorDtlService;

@Transactional  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-Context.xml",
		"classpath:spring-mvc.xml" })
public class testService {

	
	@Autowired  
	private DoorSensorDtlService doorSensorDtlService;
	
	@Autowired 
	private AdminService userService;
	
	@Autowired 
	private AcctAuthorityService roleService;
	
	@Test  
	public void testService() throws IOException { 
		System.out.println("=========START=============");
		String id="1";
//		AcctAuthority role=roleService.findById(id);
		List lst=doorSensorDtlService.findDeviceOnCurrentDay(0, "1", null, null);
		for(int i=0;i<lst.size();i++) {
			System.out.println("=========>"+lst.get(i));
		}
		
		System.out.println("=========END=============");
	}
}
