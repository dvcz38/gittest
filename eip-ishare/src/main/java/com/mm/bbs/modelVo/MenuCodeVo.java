package com.mm.bbs.modelVo;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;

import com.mm.bbs.pojo.SecCode;

public class MenuCodeVo {
	
	private int menuId; 
	private String menuCode;  //菜单名
	private String iconClass;
	private int menuState;
	
	private Set<SecCode> secCodes;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public int getMenuState() {
		return menuState;
	}

	public void setMenuState(int menuState) {
		this.menuState = menuState;
	}

	public Set<SecCode> getSecCodes() {
		return secCodes;
	}

	public void setSecCodes(Set<SecCode> secCodes) {
		this.secCodes = secCodes;
	}
	
	
	
}
