package com.mm.bbs.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 *   一级菜单code
 * @ClassName: MenuCode
 * @Description: TODO
 * @author: lenovo
 * @date: 2017年9月12日 下午1:40:26
 */
@Entity
@Table(name = "db_level_menu")
//@JsonIgnoreProperties(value={"secCodes"})   破坏了业务逻辑
public class MenuCode {

	@Id
	@Column(name = "menu_id")
	private int menuId; 
	@Column(name = "menu_code")
	private String menuCode;  //菜单名
	@Column(name = "icon_class")
	private String iconClass;
	@Column(name = "menu_state")
	private int menuState;
	
	/**
	 * 如果是EAGER，那么表示取出这条数据时，它关联的数据也同时取出放入内存中,如果是LAZY，那么取出这条数据时，它关联的数据并不取出来
	 * 
	 * 
	 */
	@OneToMany(targetEntity=SecCode.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="code")
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
