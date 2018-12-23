package com.mm.bbs.websocket;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import com.alibaba.fastjson.JSON;
import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.util.TimeUtil;
import com.mm.bbs.websocket.Dao.DoorSensorDtlWSDao;
import com.mm.bbs.websocket.Dao.Impl.DoorSensorDtlWSDaoImpl;

public class DeviceInfoWSThread extends Thread {
	
	private Session session;

//    private List<DoorSensorDtl> currentMessage;

    private DoorSensorDtlWSDao doorSensorDtlWSDao;
 

    public DeviceInfoWSThread(Session session) {

        this.session = session; 
//        currentMessage = new ArrayList<DoorSensorDtl>(); 
        doorSensorDtlWSDao = new DoorSensorDtlWSDaoImpl(); 
//        currentIndex = 0;//此时是0条消息

    }

    @Override

    public void run() {
 
    	 
        while (true) {

        	String inputDt=TimeUtil.getDateTime(); 
    		 
            List<DoorSensorDtl> list = null; 
            try { 
            	
            	Map map=new HashMap<String,Object>();
        		List countlist=doorSensorDtlWSDao.getCount(inputDt);
        		//get
        		List<DoorSensorDtl> lst=doorSensorDtlWSDao.getCurrentDayRecord("1");
//        		List<DoorSensor> lst=doorSensorDtlWSDao.getCurrentTimeLossDevice(inputDt);
        		map.put("doorstatuscount", countlist); 
        		map.put("record", lst);
        		map.put("loss", null);
        		map.put("inputDt", inputDt);
        		session.getBasicRemote().sendText(JSON.toJSONString(map)); 
                   
	          } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException | IOException e) { 
	                e.printStackTrace(); 
	         }  

            try {

                //一秒刷新一次

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }



        }

    }
}
