package com.mm.bbs.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@EnableWebMvc
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{
	
	//允许连接的域,只能以http或https开头
    String[] allowsOrigins = {"*"};
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addHandler(systemWebSocketHandler(),"/websocket.do").addInterceptors(new WebSocketHandshakeInterceptor()).setAllowedOrigins("*");
		registry.addHandler(systemWebSocketHandler(), "/sockjs/websocket.do").addInterceptors(new WebSocketHandshakeInterceptor())
	     .withSockJS();
	}
	
	@Bean
	public WebSocketHandler systemWebSocketHandler() {
		// TODO Auto-generated method stub
		return new SystemWebSocketHandler();
	}

}
