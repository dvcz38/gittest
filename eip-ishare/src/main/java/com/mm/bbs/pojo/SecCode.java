package com.mm.bbs.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *  二级菜单
 * @ClassName: SecCode
 * @Description: TODO
 * @author: lenovo
 * @date: 2017年9月12日 下午1:42:03
 */

@Entity
@Table(name = "db_two_level_menu")
public class SecCode {
	
	@Id
	@Column(name = "sec_id")
	private int secId;
	@Column(name = "sec_code")
	private String secCode; //二级菜单名称
	@Column(name = "sec_icon")
	private String secIcon; //图标
	@Column(name = "url")
	private String url;   //了菜单url
	
	/**
	 * JsonManagedReference：标记的属性会被序列化，序列化时属性默认都是会被序列化的。
	 * 反序列（deserialization，即json数据转换为对象）时，如果没有@JsonManagedReference，则不会自动注入@JsonBackReference标注的属性。
	 * JsonIgnore：直接忽略某个属性，以断开无限递归，序列化或反序列化均忽略。当然如果标注在get、set方法中，则可以分开控制，
	 * 序列化对应的是get方法，反序列化对应的是set方法。在父子关系中，当反序列化时，
	 * JsonIgnore不会自动注入被忽略的属性值（父或子），这是它跟@JsonBackReference和@JsonManagedReference最大的区别。 
	 */
	@JsonBackReference
	@ManyToOne(targetEntity = MenuCode.class)
	@JoinColumn(name = "code")
	private MenuCode menu;

	public int getSecId() {
		return secId;
	}

	public void setSecId(int secId) {
		this.secId = secId;
	}

	public String getSecCode() {
		return secCode;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}

	public String getSecIcon() {
		return secIcon;
	}

	public void setSecIcon(String secIcon) {
		this.secIcon = secIcon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MenuCode getMenu() {
		return menu;
	}

	public void setMenu(MenuCode menu) {
		this.menu = menu;
	}

	
}
