package com.mm.bbs.vo;

import java.util.Date;

import javax.persistence.Column;

import com.mm.bbs.pojo.Admin;

public class UserVo {
private Integer id;
	
	 
	private String name;
	 
	private String password;
	 
	private String email;
	 
	private String phone;
	 
	private Date joindate;
	 
	private String role;
	 
	private Integer state;
	
	public UserVo(Admin usr)
	{
		this.id=usr.getId();
		this.name=usr.getName();
		this.password=usr.getPassword();
		this.email=usr.getEmail();
		this.phone=usr.getPhone();
		this.role=usr.getRole();
		this.joindate=usr.getJoindate();
		this.state=usr.getState();
	}
	public UserVo(Integer id, String name, String password, String email, String phone, Date joindate, String role,
			Integer state) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.joindate = joindate;
		this.role = role;
		this.state = state;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	
}
