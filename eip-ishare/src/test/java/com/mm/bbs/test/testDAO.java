package com.mm.bbs.test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.mm.bbs.dao.AcctAuthorityDao;
import com.mm.bbs.dao.AdminDao;
import com.mm.bbs.dao.DoorSensorDao;
import com.mm.bbs.dao.DoorSensorDtlDao;
import com.mm.bbs.pojo.Admin;
import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.pojo.AcctAuthority;
import com.mm.bbs.util.CheckState;
import com.mm.bbs.util.CryptographyUtil;
import com.mm.bbs.util.FileUtil;
import com.mm.bbs.util.PropertiesReader;
import com.mm.bbs.util.TimeUtil;
import com.mm.bbs.websocket.Dao.DoorSensorDtlWSDao;
import com.mm.bbs.websocket.Dao.Impl.DoorSensorDtlWSDaoImpl;

@Transactional  
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-Context.xml",
		"classpath:spring-mvc.xml" })
public class testDAO {
//Logger log = Logger.getLogger(JunitTest.class);
	 
	
	@Autowired  
	private DoorSensorDtlDao doorSensorDtlDao;
	
	
	@Autowired  
	private DoorSensorDao doorSensorDao;
	@Autowired 
	private AdminDao userDao;
	
	@Autowired 
	private AcctAuthorityDao roleDao;

	
	@Test  
	public void test11() throws IOException { 
		System.out.println("=========START=============");
//		doorSensorDao.findEnityById(DoorSensorDtl.class, "1");
//		List<DoorSensorDtl> menus = doorSensorDao.findDiviceByStaffCheckOnDate(false, new Date("2018-11-12"));
//		DoorSensorDtl ds=doorSensorDao.getById(DoorSensorDtl.class, 1);
//		System.out.println("====>"+ds.getInputDt()+'|'+ds.getDevice().getDeviceDesc()+'|'+ds.getDoorDistance());
//		long i=doorSensorDao.getDoorSensorCountByState("Close","2018-11-13 04:23:00");
		Integer id=2;
		String name="Admin";
		String inputDt=TimeUtil.getCurrentHour();
		System.out.println("inputDt====>"+inputDt);
//		Admin obj1=(Admin) userDao.getById(Admin.class, id);
//		List<AcctAuthority> obj=roleDao.findByName(name);
		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date joindate;
//		joindate = (Date)formatter.parseObject("2018-11-13 04:23:00");
//		List lst=doorSensorDao.findAll(DoorSensor.class);
//		Date fdate = null;
//		Date todate = null;
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(startTime);
//		try {
//			fdate = (Date)formatter.parseObject("2018-11-13 06:00:00");
//			todate= (Date)formatter.parseObject("2018-11-13 22:23:00");
			
//		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List lst=doorSensorDtlDao.getCount("2018-12-01 15:00:00");
		
//		List<DoorSensorDtl> lst=doorSensorDtlDao.findDeviceByParams(inputDt, "F", 0, "Open");
//		List<DoorSensorDtl> lst=doorSensorDtlDao.findDeviceByParamsOnHour(null, 0, null);
//		List<DoorSensorDtl> lst=doorSensorDtlDao.findDeviceByChnlNo(0,1);
//		List<DoorSensorDtl> lst=doorSensorDtlDao.findDeviceByStaffCheck(false, "2018-11-13 06:00:00", "2018-11-13 22:23:00");
//		List<DoorSensorDtl> lst=doorSensorDtlDao.findAutoCheckDeviceInTime(channelNo, fdate)(false, fdate, todate);
//		List<DoorSensorDtl> lst=doorSensorDtlDao.findDeviceByStaffCheckOnDate(false, fdate);
//		AcctAuthority obj=roleDao.getById(AcctAuthority.class, id);
//				.findById(id);
//		for(DoorSensorDtl ds:lst) {
//			System.out.println("====>"+ds.getInputDt()+'|'+ds.getIsStaffCheck()+'|'+ds.getDevice().getDeviceDesc()+'|'+ds.getDevice().getChannelNo()+"|"+ds.getDoorDistance());
//		}
//		 Map<String,Object> map=new LinkedHashMap<String,Object>();
//		 map.put("total", lst.size());
//		 map.put("rows", lst); 
//		 return map; 
//		System.out.println("====>"+map);
//		menuService.finds();

		System.out.println("=========END=============");
	  }

    @Test  
    public void test() throws IOException, ParseException { 

//    	public List getCount(String inputDt) 
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		Date d = sdf.parse("2018/04/16");
//		
//		TimeZone curTimeZone = TimeZone.getTimeZone("GMT+8");
//		Calendar c = Calendar.getInstance(curTimeZone);
//		c.setTime(d);
//		c.set(Calendar.HOUR_OF_DAY, 0);
//		c.set(Calendar.MINUTE, 0);
//		c.set(Calendar.SECOND, 0);
//		Date z = c.getTime();
//		System.out.println(sdf.format(z));
    	
    	String path = System.getProperty("user.dir");
		String name=TimeUtil.getDate();
		String fileName=path+System.getProperty("file.separator")+name;
		System.out.println("===UDP SERVER===>file name:"+fileName);
		FileUtil.write(fileName, "11111111111");
		
		PropertiesReader prop=new PropertiesReader();
		String val=prop.getValue("jdbc.url");
		System.out.println("=========url>"+val);
 
    }  
    
    
    @Test
	public void test2() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
//    	System.out.println(CryptographyUtil.md5("admin", "ADMIN-10001"));
    	System.out.println("=========START=============");
//    	System.out.println(CheckState.Autocheck.getValue());
    	
    	String deviceId=null;
		String inputDt=null;
		String doorDistance=null;
		String doorStatus=null;
		String isStaffCheck=null; 
		String signlpwr=null; 
		String batVol=null;
		String strtest="1*2018-12-09 13:41:00*0*Close*F*-96.4*3.67222";
//		 ('1', '2018-12-03 13:41:00', '0', 'Close', 'F', '-96.4', '3.67222');
		String [] items=strtest.split("\\*");
		for(int i=0;i<items.length;i++) {
			switch(i) {
			case 0:
				 deviceId=items[0];
				continue;
			case 1:
				 inputDt=items[1];
				 continue;
			case 2:
				doorDistance=items[2];
				continue;
			case 3:
				doorStatus=items[3];
				continue;
			case 4:
				isStaffCheck=items[4]; 
				continue;
			case 5:
				signlpwr=items[5];
				continue;
			case 6:
				batVol=items[6];
				continue;
			}
		
		}
		DoorSensorDtlWSDao doorSensorDtlWSDao = new DoorSensorDtlWSDaoImpl(); 
		List<DoorSensorDtl> lst =doorSensorDtlWSDao.getCurrentDayRecord();
		System.out.println("====>"+JSON.toJSONString(lst.get(0)));
//		doorSensorDtlWSDao.save(deviceId, inputDt, doorDistance, doorStatus, isStaffCheck, signlpwr, batVol);
		
    	System.out.println("=========END=============");
    }
	@Test
	public void test1() throws IOException  {
	 
		StringBuilder hql=new StringBuilder();
		hql.append("FROM DoorSensorDtl a where  1=1 ");
		
		hql.append("and inputDt in (");
		//
		List<Map<String, String>> lst;
		try {
			lst = TimeUtil.getAllHoursofDay();
			int f=lst.size()-1;
			for(int i=0;i<lst.size();i++) {
				Map map=lst.get(i);
				hql.append("'").append(map.get(String.valueOf(i)));
				
				if(i!=f) {
					hql.append("',");
				}
				 
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hql.append(") ");
		System.out.println("====>"+hql.toString());
	}
}
