package com.mm.bbs.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;
import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.service.DoorSensorDtlService;
import com.mm.bbs.service.DoorSensorService;
import com.mm.bbs.util.TimeUtil;
import com.mm.bbs.websocket.Dao.DoorSensorDtlWSDao;
import com.mm.bbs.websocket.Dao.Impl.DoorSensorDtlWSDaoImpl;

 

@Service
public class SystemWebSocketHandler implements WebSocketHandler{
	
 
	private static final Logger logger = Logger.getLogger(SystemWebSocketHandler.class);
	
    private static final List<WebSocketSession> users;

    static {
        users = new ArrayList<>();
        
        
    }
    
    
//    private WebSocketService webSocketService;
    @Autowired
	private DoorSensorService doorSensorService;
    
    @Autowired
   	private DoorSensorDtlService doorSensorDtlService;
    
    private DoorSensorDtlWSDao doorSensorDtlWSDao;

   
    
    public SystemWebSocketHandler() {
    	doorSensorDtlWSDao = new DoorSensorDtlWSDaoImpl(); 
    }
    
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("connect to the websocket success...");
		users.add(session);
		String userName=(String)(session.getAttributes().get("mall"));
		if(userName!=null) {
			//
//			int count = webSocketService.getUnReadNews((String) session.getAttributes().get(Constants.WEBSOCKET_USERNAME));
			
			
	        
            session.sendMessage(new TextMessage(  "Hello World"));
		}
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("websocket handle Message....");
		
//		byte[] bytes = message.asBytes();
//        String params = new String(bytes);
		String inputDt=TimeUtil.getDateTime();
//		List lst=doorSensorDtlService.getDoorStatusCount(inputDt);
		List<DoorSensor> lst=doorSensorDtlWSDao.getCurrentTimeLossDevice(inputDt);
//        JSONObject object=new JSONObject()
        
        try {
        	
        	WebSocketMessage message1 = new TextMessage(JSON.toJSONString(lst));
            session.sendMessage(message1);
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		if(session.isOpen()) {
			session.close();
		}
		logger.debug("websocket connection closed....");
		users.remove(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("websocket connection closed ...");
		users.remove(session);
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void sendMessageToUsers(TextMessage message) {
		for(WebSocketSession user:users) {
			try {
				if(user.isOpen()) {
					user.sendMessage(message);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendMessageToUser(String username,TextMessage message) {
		for (WebSocketSession user : users) {
            if (user.getAttributes().get("name").equals(username)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}
