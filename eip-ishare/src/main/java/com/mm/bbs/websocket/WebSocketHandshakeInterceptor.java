package com.mm.bbs.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Component
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
	
	private static final Logger logger = Logger.getLogger(WebSocketHandshakeInterceptor.class);

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		// TODO Auto-generated method stub
		if(request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest= (ServletServerHttpRequest) request;
			HttpSession session=servletRequest.getServletRequest().getSession(false);
			if(session!=null) {
				String id=session.getId();
				logger.debug("before handshake:"+id);
			}
			String type = servletRequest.getServletRequest().getParameter("type");
	        attributes.put("mall",type);
		}
		
        return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub
		logger.debug("after handshake:");
	}
	
}
