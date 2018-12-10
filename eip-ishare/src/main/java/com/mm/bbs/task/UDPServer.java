package com.mm.bbs.task;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Service;


public class UDPServer implements ServletContextListener {
	private Thread thread;
	//线程销毁
	public void contextDestroyed(ServletContextEvent sce) {
		if (thread!=null&&thread.isInterrupted()) {
			thread.interrupt();
		}
	}
	//线程启动
	public void contextInitialized(ServletContextEvent sce) {
		if(thread==null){
			ReceiveSyslog receiveSyslog = new ReceiveSyslog();
			thread = new Thread(receiveSyslog);
			thread.start();
		}
	}
}
