package com.mm.bbs.websocket;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.service.DoorSensorService;
import com.mm.bbs.util.DBUtil;
import com.mm.bbs.websocket.Dao.DoorSensorDtlWSDao;
import com.mm.bbs.websocket.Dao.Impl.DoorSensorDtlWSDaoImpl;



public class MyThread extends Thread {
	 	
		private Session session;

	    private List<DoorSensorDtl> currentMessage;
//
	    private DoorSensorDtlWSDao doorSensorDtlWSDao;

	    private int currentIndex;
	    
	    private boolean stop=true;
	    
	    private int sum;
	    private int new_sum;
	    
	    public void stopThread() {
	    	stop=false;
	    }

	    public MyThread(Session session) {

	        this.session = session; 
	        currentMessage = new ArrayList<DoorSensorDtl>(); 
	        doorSensorDtlWSDao = new DoorSensorDtlWSDaoImpl(); 
	        currentIndex = 0;//此时是0条消息

	    }

	    @Override

	    public void run() {

	    	
	    	try {
				sum=doorSensorDtlWSDao.getCurrentDayRecordCount();
			} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        while (stop) {

	            List<DoorSensorDtl> list = null; 
	            try { 
	            	new_sum=doorSensorDtlWSDao.getCurrentDayRecordCount();
	            	if(sum!=new_sum) {
	            		System.out.println("====>change");
	            		sum=new_sum;
	                    list = doorSensorDtlWSDao.getCurrentDayRecord(); 
	                    if (list != null && currentIndex < list.size()) {

	    	                for (int i = currentIndex; i < list.size(); i++) {
	    	                 
	    	                	System.out.println("JSON Object ==>"+JSON.toJSONString(list.get(i)));
	    	                	 session.getBasicRemote().sendText(JSON.toJSONString(list.get(i)));
	    	                	 
	    	                }
	    	             }
	            	}
	                   
		          } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) { 
		                e.printStackTrace(); 
		         } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            
	           /* if (list != null && currentIndex < list.size()) {

	                for (int i = currentIndex; i < list.size(); i++) {

	                    try {
	                    	JSON.toJSONString()
	                        session.getBasicRemote().sendText(JSON.toJSONString());

//	                            session.getBasicRemote().sendObject(list.get(i)); //No encoder specified for object of class [class DoorSensor]

	                    } catch (IOException e) {

	                        e.printStackTrace();

	                    }

	                }

	                currentIndex = list.size();
	            }*/
	            try {

	                //一秒刷新一次

	                Thread.sleep(1000);

	            } catch (InterruptedException e) {

	                e.printStackTrace();

	            }



	        }

	    }
}