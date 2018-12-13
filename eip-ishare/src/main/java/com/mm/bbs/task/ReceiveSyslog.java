package com.mm.bbs.task;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;
import com.mm.bbs.service.DoorSensorDtlService;
import com.mm.bbs.service.impl.DoorSensorDtlServiceImpl;
import com.mm.bbs.util.FileUtil;
import com.mm.bbs.util.TimeUtil;
import com.mm.bbs.websocket.Dao.DoorSensorDtlWSDao;
import com.mm.bbs.websocket.Dao.Impl.DoorSensorDtlWSDaoImpl;
 

@Service
public class ReceiveSyslog implements Runnable{
	private final int PORT=8800;
	
//	@Resource
	
//	@Bean
//	 public DoorSensorDtlService dsService() {
//	        return new DoorSensorDtlServiceImpl();
//	}
//	 
//	DoorSensorDtlService doorSensorDtlService=dsService() ;
	private DoorSensorDtlWSDao doorSensorDtlWSDao;
	
	public ReceiveSyslog() {
//		 this.session = session; 
//	        currentMessage = new ArrayList<DoorSensorDtl>(); 
	        doorSensorDtlWSDao = new DoorSensorDtlWSDaoImpl(); 
//	        currentIndex = 0;//此时是0条消息
	}

	public void run() {
		
//		DoorSensorDtlService doorSensorDtlService=(DoorSensorDtlService) AppContextUtil.getBean("doorSensorDtlService");
		System.out.println("===UDP SERVER===>");
		//准备空包
		byte[] infos = new byte[1024];
		DatagramPacket packet = new DatagramPacket(infos, infos.length);
		//准备socket
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(PORT);
			String str ="";
			while(true){
				//接收数据包
				socket.receive(packet);
				str = new String(packet.getData(),0,packet.getLength());
				System.out.println("===UDP SERVER===received >"+str);
				
				
				try {
					String deviceId=null;
					String inputDt=null;
					String doorDistance=null;
					String doorStatus=null;
					String isStaffCheck=null; 
					String signlpwr=null; 
					String batVol=null;
					String strtest="1*2018-12-09 18:41:00*0*Close*F*-96.4*3.67222";
//					 ('1', '2018-12-03 13:41:00', '0', 'Close', 'F', '-96.4', '3.67222');
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
					 
//					String deviceId=items[0];
//					String inputDt=items[1];
//					String doorDistance=items[2];
//					String doorStatus=items[3];
//					String isStaffCheck=items[4]; 
//					String signlpwr=items[5]; 
//					String batVol=items[6];
					doorSensorDtlWSDao.save(deviceId, inputDt, doorDistance, doorStatus, isStaffCheck, signlpwr, batVol);
				
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				StringBuilder sb=new StringBuilder();
				sb.append("Server:").append(str);
				System.out.println("===UDP SERVER===prepare to send data >"+sb.toString());
				
				//send feeback to client
				DatagramPacket dp_send= new DatagramPacket(sb.toString().getBytes(),sb.toString().length(),packet.getAddress(),packet.getPort());
				socket.send(dp_send);
//				packet.setLength(1024);
				//(infos);
				//输出
				
				String path = System.getProperty("user.dir");
				String name=TimeUtil.getDate();
				String fileName=path+System.getProperty("file.separator")+name;
				System.out.println("===UDP SERVER===>file name:"+fileName);
				FileUtil.write(fileName, str);
//				DoorSensorDtl entity=new DoorSensorDtl();
//				DoorSensor ds=new DoorSensor();
//				ds.setId(1);
//				entity.setBattVol((float) 4.32);
//				entity.setDoorStatus("Open");
//				entity.setDevice(ds);
//				entity.setDoorDistance(24);
//				entity.setInputDt(new Date());
//				entity.setNbSignalPwr(-98);
//				doorSensorDtlService.save(entity);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			socket.close();
		}
	}
}
