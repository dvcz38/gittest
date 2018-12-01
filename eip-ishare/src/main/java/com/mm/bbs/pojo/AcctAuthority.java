package com.mm.bbs.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="acctAuthority")
public class AcctAuthority
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="authorityId", unique=true, nullable=false)
  private int authorityId;
  @Column(name="authorityDesc")
  private String authorityDesc;
  @Column(name="isRead")
  private String isRead;
  @Column(name="isAdd")
  private String isAdd;
  @Column(name="isEdit")
  private String isEdit;
  @Column(name="isDelete")
  private String isDelete;
  @Column(name="isDownload")
  private String isDownload;
  @JsonFormat(pattern="yyy-MM-dd HH:mm:ss", timezone="GMT+8")
  @Column(name="updateDt")
  private Date updateDt;
  
  public int getAuthorityId()
  {
    return this.authorityId;
  }
  
  public void setAuthorityId(int authorityId)
  {
    this.authorityId = authorityId;
  }
  
  public String getAuthorityDesc()
  {
    return this.authorityDesc;
  }
  
  public void setAuthorityDesc(String authorityDesc)
  {
    this.authorityDesc = authorityDesc;
  }
  
  public String getIsRead()
  {
    return this.isRead;
  }
  
  public void setIsRead(String isRead)
  {
    this.isRead = isRead;
  }
  
  public String getIsAdd()
  {
    return this.isAdd;
  }
  
  public void setIsAdd(String isAdd)
  {
    this.isAdd = isAdd;
  }
  
  public String getIsEdit()
  {
    return this.isEdit;
  }
  
  public void setIsEdit(String isEdit)
  {
    this.isEdit = isEdit;
  }
  
  public String getIsDelete()
  {
    return this.isDelete;
  }
  
  public void setIsDelete(String isDelete)
  {
    this.isDelete = isDelete;
  }
  
  public String getIsDownload()
  {
    return this.isDownload;
  }
  
  public void setIsDownload(String isDownload)
  {
    this.isDownload = isDownload;
  }
  
  public Date getUpdateDt()
  {
    return this.updateDt;
  }
  
  public void setUpdateDt(Date updateDt)
  {
    this.updateDt = updateDt;
  }
}