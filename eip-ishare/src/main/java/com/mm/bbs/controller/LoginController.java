package com.mm.bbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mm.bbs.util.CryptographyUtil;

import com.mm.bbs.vo.BaseDataVo;



@Controller
@RequestMapping("/login")
@SuppressWarnings("all")
public class LoginController {
	/**
	 * http://localhost:8081/S2SH-bbs/login/doLogin.do
	 * @Title: doLogin
	 * @Description: TODO
	 * @param request
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "/doLogin.do",method = RequestMethod.POST)
	@ResponseBody
	public BaseDataVo doLogin(HttpServletRequest request){
		BaseDataVo baseDataVo = new BaseDataVo();
		String userName = request.getParameter("user_Name");
		String password = request.getParameter("user_Pwd");
		// String userName = request.getParameter("userName");
		// String password = request.getParameter("password");
		// 获取当前登录用户(SecurityUtils工具类)
		Subject subject = SecurityUtils.getSubject();
		// 创建登录令牌
				UsernamePasswordToken token = new UsernamePasswordToken(userName,
						CryptographyUtil.md5(password, "ADMIN-10001"));
		try {
			// 当前用户通过令牌登录(跳转至MyRealm类中进行身份,权限认证)
				subject.login(token);
				Session session = subject.getSession();
				System.out.println("sessionId:" + session.getId());
				System.out.println("sessionHost:" + session.getHost());
				System.out.println("sessionTimeout:" + session.getTimeout());
				session.setAttribute("userInfo", userName);
				
				baseDataVo.setMsg("success");
				
				return baseDataVo;
			} catch (Exception e) {
					e.printStackTrace();
				//	request.setAttribute("user", user);
					request.setAttribute("errorMsg", "user or passwrod error");
					
					baseDataVo.setMsg("error");
					return baseDataVo;
			}		
	}
	
}
