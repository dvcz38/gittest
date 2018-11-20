package com.mm.bbs.vo;

import java.util.List;

import com.mm.bbs.pojo.MenuCode;



public class BaseDataVo {
	private String msg;
	
	private List<MenuCode> menus;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<MenuCode> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuCode> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "BaseDataVo [msg=" + msg + ", menus=" + menus + "]";
	}


}
