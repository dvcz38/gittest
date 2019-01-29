<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>

<link rel="stylesheet" type="text/css" href="${ctx}/easyui/1.3.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/wu.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/icon.css" />

<script type="text/javascript" src="${ctx}/easyui/1.3.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
 
<script type="text/javascript" src="${ctx}/javascript/userPage/userlist.js"></script> 
<script type="text/javascript">var ctx = "${ctx}"</script>	
<style type="text/css">
    .panel-title {
      font-size: 12px @!important;
      font-weight: bold;
      color: #0E2D5F;
      height: 16px @!important;
      line-height: 16px @!important;
    }
    .wu-text{
        padding: 3px @!important;
        border: 1px #95b8e7 solid @!important;
        width: 260px @!important;
        height: 14px @!important;
        line-height: 14px @!important;
    }
</style>
</head>



<body class="easyui-layout">




<div id="userInfoManage_layout_center" data-options="region:'center',border:false" style="overflow: hidden;">
    <table id="userInfoManage_datagrid"><tr></tr></table>
</div>


 
<!-- 配置修改框面板 -->
    <div id="updateUser" class="easyui-dialog" title="Edit User Information"
        style="width: 400px; height: 450px;padding:10px" data-options="modal:true">
        
        <form id="upUserForm" method="post">
       
        <!--id默认隐藏,这样就不允许修改 -->
        <div style="margin-bottom: 20px;"> 
             
           <input type="hidden" id="id"  name="id" >
              
           
            </div>
            <table class="main">
         	<tr>
            <td width="60" align="right">Join Date:</td>
             <td> 
               
                <input name="joindate" type="text" class="easyui-datetimebox wu-text"  style="width:210px">  
             </td>
            </tr>
            <tr>
	            <td width="60" align="right">User Name:</td>
	            <td>
	            	<input class="easyui-textbox wu-text" name="name" style="width: 200px" required="required"> 
	            </td>
            </tr>
            
            <tr >
	            <td width="60" align="right">password:</td>
	            <td>
	            	  <input class="easyui-textbox wu-text" name="password" style="width: 200px" required="required" type="text" pattern="{6,}">
	            </td>
            </tr>
            <tr>
	             <td width="60" align="right">Email:</td>
	             <td>
	            	 <input class="easyui-textbox wu-text" name="email" style="width: 200px" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" type="email">
	             </td>
            </tr> 
            <tr>
            	<td width="120" align="right">Phone:</td>
             	<td>
            		<input class="easyui-textbox wu-text" name="phone" style="width: 200px">
             	</td>
            </tr>
            <tr>
            <td width="60" align="right">Role:</td>
             <td> 
               <select id="role" class="easyui-combobox" name="role" style="width:200px;">
				    <option value="3">COMMON</option>
				    <option value="2">ADMIN</option> 
				    <option value="1">SUPER ADMIN</option> 
				</select> 
             </td>
            </tr>
            
            <tr>
            <td width="60" align="right">State:</td>
             <td>  
                <select id="state" class="easyui-combobox" name="state" style="width:200px;">
				    <option value="1">WORK</option>
				    <option value="0">QUIT</option> 
				</select> 
             </td>
            </tr>
        </table>   
        </form>
        <div style="text-align: center; padding: 5px 0;">
           
            <a href="javascript:void(0)" class="l-btn"
                onclick="updateForm()" id="tt"><span class="l-btn-left"><span class="l-btn-text icon-ok l-btn-icon-left">submit</span></span></a> 
        </div>
    </div>
          <!-- 配置增加框 -->
    <div id="addUser" class="easyui-dialog" title="Add User Information"
        style="width: 400px; height: 450px;padding:10px;" data-options="modal:true">
        
        <form id="addUserForm" method="post">
           
                </br>
           <table class="main">
            
            
             <tr>
                <td width="60" align="right">User Name:</td>
	           
	            <td>
	            	<input class="easyui-textbox wu-text" name="name" style="width: 200px" required="required"> 
	            </td>
            </tr>
             <tr >
	            <td width="60" align="right">password:</td>
	            <td>
	            	  <input class="easyui-textbox wu-text" name="password" style="width: 200px" required="required" type="text" pattern="{6,}">
	            </td>
            </tr>
            <tr>
	             <td width="60" align="right">Email:</td>
	             <td>
	            	 <input class="easyui-textbox wu-text" name="email" style="width: 200px" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" type="email">
	             </td>
            </tr> 
            <tr>
            	<td width="120" align="right">Phone:</td>
             	<td>
            		<input class="easyui-textbox wu-text" name="phone" style="width: 200px">
             	</td>
            </tr>
            <tr>
            <td width="60" align="right">Join Date:</td>
            
             <td> 
               <input name="joindate" type="text" class="easyui-datetimebox wu-text"  style="width:210px">  
             </td>
            </tr>
             <tr>
            <td width="60" align="right">Role:</td>
             <td> 
               <select id="role" class="easyui-combobox" name="role" style="width:200px;">
				    <option value="3">COMMON</option>
				    <option value="2">ADMIN</option> 
				    <option value="1">SUPER ADMIN</option> 
				</select> 
             </td>
            </tr>
            
            <tr>
            <td width="60" align="right">State:</td>
             <td>  
                <select id="state" class="easyui-combobox" name="state" style="width:200px;">
				    <option value="1">WORK</option>
				    <option value="0">QUIT</option> 
				</select> 
             </td>
            </tr>
        </table>   
        </form>
       
        <div style="text-align: center; padding: 5px 0;">
        

            <a href="javascript:void(0)" class="l-btn"
                onclick="addForm()" id="tt"><span class="l-btn-left"><span class="l-btn-text icon-ok l-btn-icon-left">submit</span></span></a> 
        </div>
    </div>
	
</body>
</html>