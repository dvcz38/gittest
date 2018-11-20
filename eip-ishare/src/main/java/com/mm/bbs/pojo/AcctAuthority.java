package com.mm.bbs.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "acctAuthority")
public class AcctAuthority {
	
	@Id
	@Column(name = "authorityId", unique = true, nullable = false)
	private int authorityId;
	
	@Column(name = "authorityDesc")
	private String authorityDesc;
	
	@Column(name = "isRead")
	private String isRead;
	
	@Column(name = "isAdd")
	private String isAdd;
	
	@Column(name = "isEdit")
	private String isEdit;

	@Column(name = "isDelete")
	private String isDelete;
	
	@Column(name = "isDownload")
	private String isDownload;
	
	@Column(name = "updateDt")
	private Date updateDt;
	
	public AcctAuthority() {
//		this.authorityId=DEFAULT_AUTH_LEVEL;
	}
	public AcctAuthority(int authorityId) {
		 this.authorityId=authorityId;
	}
	
	public int getAuthorityId() {
		return authorityId;
	}
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}
	
	public String getAuthorityDesc() {
		return authorityDesc;
	}
	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}
	
	public Date getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	public String getIsAdd() {
		return isAdd;
	}
	public void setIsAdd(String isAdd) {
		this.isAdd = isAdd;
	}
	public String getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getIsDownload() {
		return isDownload;
	}
	public void setIsDownload(String isDownload) {
		this.isDownload = isDownload;
	}
	
	

}
