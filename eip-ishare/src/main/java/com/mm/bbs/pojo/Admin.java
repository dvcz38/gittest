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
@Table(name="dbs_admin_info")
public class Admin
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private int id;
  @Column(name="name")
  private String name;
  @Column(name="password")
  private String password;
  @Column(name="email")
  private String email;
  @Column(name="phone")
  private String phone;
  @JsonFormat(pattern="yyy-MM-dd HH:mm:ss", timezone="GMT+8")
  @Column(name="joindate")
  private Date joindate;
  @Column(name="role")
  private String role;
  @Column(name="state")
  private int state;
  
  public Admin(int id, String name, String password, String email, String phone, Date joindate, String role, int state)
  {
    this.id = id;
    this.name = name;
    this.password = password;
    this.email = email;
    this.phone = phone;
    this.joindate = joindate;
    this.role = role;
    this.state = state;
  }
  
  public Admin() {}
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getPhone()
  {
    return this.phone;
  }
  
  public void setPhone(String phone)
  {
    this.phone = phone;
  }
  
  public Date getJoindate()
  {
    return this.joindate;
  }
  
  public void setJoindate(Date joindate)
  {
    this.joindate = joindate;
  }
  
  public String getRole()
  {
    return this.role;
  }
  
  public void setRole(String role)
  {
    this.role = role;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setState(int state)
  {
    this.state = state;
  }
  
  public String toString()
  {
    return 
      "Admin [id=" + this.id + ", name=" + this.name + ", password=" + this.password + ", email=" + this.email + ", phone=" + this.phone + ", joindate=" + this.joindate + ", role=" + this.role + ", state=" + this.state + "]";
  }
}