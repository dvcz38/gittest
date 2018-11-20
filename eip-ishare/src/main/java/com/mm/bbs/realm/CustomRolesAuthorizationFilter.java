/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT China Mobile (SuZhou) Software Technology Co.,Ltd. 2016
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.mm.bbs.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * 自定义过滤器配置 一个路径多个角色访问
 */
public class CustomRolesAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) throws Exception {
		// TODO Auto-generated method stub

		// 当前登录用户
		Subject subject = getSubject(req, resp);

		// 获取对应的角色
		String[] rolesArray = (String[]) mappedValue;

		if (rolesArray == null || rolesArray.length == 0) { // 没有角色限制，有权限访问
			return true;
		}
		for (int i = 0; i < rolesArray.length; i++) {
			// 授予角色(当前用户)--(roleOrFilter[admin,visitor])
			if (subject.hasRole(rolesArray[i])) { // 若当前用户是rolesArray中的任何一个，则有权限访问
				return true;
			}
		}

		return false;

	}

}
