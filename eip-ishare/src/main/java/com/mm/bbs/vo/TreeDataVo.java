package com.mm.bbs.vo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import com.mm.bbs.pojo.MenuCode;
import com.mm.bbs.pojo.SecCode;

public class TreeDataVo{
	private String id;//节点ID，对加载远程数据很重要。
	private String text;//显示节点文本。
	private String state;//节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
	private String checked;//表示该节点是否被选中。
	private String attributes;//被添加到节点的自定义属性。
	private String children;// 一个节点数组声明了若干节点。
	//一级菜单
	private int menuId; 
	private String menuCode;  //菜单名
	private String iconClass;
	private int menuState;
	//二级菜单
	private List<SecCode> secCodes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public String getChildren() {
		return children;
	}
	public void setChildren(String children) {
		this.children = children;
	}
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
	public List<SecCode> getSecCodes() {
		return secCodes;
	}
	public void setSecCodes(List<SecCode> secCodes) {
		this.secCodes = secCodes;
	}
	@Override
	public String toString() {
		return "TreeDataVo [id=" + id + ", text=" + text + ", state=" + state + ", checked=" + checked + ", attributes="
				+ attributes + ", children=" + children + ", menuId=" + menuId + ", menuCode=" + menuCode
				+ ", iconClass=" + iconClass + ", menuState=" + menuState + ", secCodes=" + secCodes + "]";
	}
	
}
