package com.mm.bbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.weaver.SignatureUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * String path = "http://192.168.133.1:8081/eip-ishare/weixinServlet";
 * @ClassName: LoginServlet
 * @Description: TODO
 * @author: lenovo
 * @date: 2017年12月26日 下午4:42:51
 */
public class WeixinServlet extends HttpServlet {
	
	private static Logger log = Logger.getLogger(WeixinServlet.class);
	public static final String TOKEN = "wexin_notif_token";
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("********************开始执行*********************");
		request.setCharacterEncoding("utf-8");
		//微信加密签名
		String signature = request.getParameter("signature");
		//时间
		String timestamp = request.getParameter("timestamp");
		//随机数
		String nonce = request.getParameter("nonce");
		//随机字符串
		String echostr = request.getParameter("echostr");
		try {
			PrintWriter out = response.getWriter();
			
			out.append(echostr);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doPost(request, response);
		log.info("********************开始执行*********************");

	}
}
