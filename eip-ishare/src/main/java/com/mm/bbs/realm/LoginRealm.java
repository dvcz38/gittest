package com.mm.bbs.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.mm.bbs.pojo.Admin;
import com.mm.bbs.service.AdminService;


@SuppressWarnings("all")
public class LoginRealm extends AuthorizingRealm {
	
	@Resource 
	private AdminService adminService;

	/**
	 * 用户角色与权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		String userName = (String) principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 给用户增加角色
		// System.out.println(userService.getRoles(userName));
		// simpleAuthorizationInfo.setRoles(userService.getRoles(userName));
//		System.out.println("角色" + simpleAuthorizationInfo.getRoles());
		// 给用户增加权限
		// simpleAuthorizationInfo.setStringPermissions(userService.getPermissions(userName));
//		System.out.println("权限" + simpleAuthorizationInfo.getStringPermissions());

		// 创建session
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String str1 = simpleAuthorizationInfo.getStringPermissions().toString().replace("[", "'").replace("]", "'")
				.toString();

		session.setAttribute("vailDate", str1);

		return simpleAuthorizationInfo;
	}

	/**
	 * 用于用户登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// 获取当前登录的用户名(表单提交的用户数据信息)
		String userName = (String) token.getPrincipal();
//		UserInfo user = userInfoService.findByUser(userName);
		List<Admin> users = adminService.findByAdmin(userName);
		if (users.get(0)!=null&&users.size()==1) {
			if (users.get(0).getState() == 0) {

				return null;
			} else {

				// 存入AuthenticationInfo进行处理
				// 此处无需比对，比对的逻辑Shiro会做，我们只需返回一个和令牌相关的正确的验证信息，因此在随后的登录页面上只有admin/admin123才能通过验证
				AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(users.get(0).getName(),
						users.get(0).getPassword(), "admin_");

				return authenticationInfo;
			}

		} else {

			return null;
		}
		
		
	}
}
