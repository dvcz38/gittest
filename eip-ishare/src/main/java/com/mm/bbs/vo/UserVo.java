package com.mm.bbs.vo;

import com.mm.bbs.pojo.Admin;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserVo
{
  private int id;
  private String name;
  private String password;
  private String email;
  private String phone;
  private String joindate;
  private String role;
  private int state;
  
  public UserVo() {}
  
  public UserVo(Admin usr)
  {
    this.id = usr.getId();
    this.name = usr.getName();
    this.password = usr.getPassword();
    this.email = usr.getEmail();
    this.phone = usr.getPhone();
    this.role = usr.getRole();
    this.joindate = usr.getJoindate().toString();
    this.state = usr.getState();
  }
  
  public UserVo(int id, String name, String password, String email, String phone, Date joindate, String role, int state)
  {
    this.id = id;
    this.name = name;
    this.password = password;
    this.email = email;
    this.phone = phone;
    this.joindate = (joindate != null ? joindate.toString() : null);
    this.role = role;
    this.state = state;
  }
  
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
  
  public String getJoindate()
  {
    return this.joindate;
  }
  
  public void setJoindate(String joindate)
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
  
  public Admin getPojo()
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      Date joindate = (Date)formatter.parseObject(getJoindate());
      return new Admin(this.id, this.name, this.password, this.email, this.phone, joindate, this.role, this.state);
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
