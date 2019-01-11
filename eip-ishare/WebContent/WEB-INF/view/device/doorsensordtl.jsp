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
<title>door sensor record</title>

<link rel="stylesheet" type="text/css" href="${ctx}/easyui/1.3.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/wu.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/icon.css" />

<script type="text/javascript" src="${ctx}/easyui/1.3.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="${ctx}/javascript/device/doorsensordtl.js"></script> 
<script type="text/javascript">var ctx = "${ctx}"</script>	
</head>



<body class="easyui-layout">
 

<div id="userInfoManage_layout_center" data-options="region:'center',border:false" style="overflow: hidden;">
    <table id="userInfoManage_datagrid" ><tr></tr></table>
</div>


<!-- 配置修改框面板 -->
    <div id="updateUser" class="easyui-dialog" title="Edit User Information"
        style="width: 400px; height: 450px;" data-options="modal:true">
        
        <form id="upUserForm" method="post">
       
        <!--id默认隐藏,这样就不允许修改 -->
        <div style="margin-bottom: 20px;"> 
             <!--
          
               <tr>
	            <td><span>Device ID</span></td>
	            <td>
	            	<input class="easyui-textbox" name="deviceId" style="width: 200px" readonly="true"> 
	            </td>
            </tr>
           -->
           <input type="hidden" id="id"  name="id" >
            <input type="hidden" id="deviceId"  name="deviceId" >
            </div>
            <table class="main">
           
            <tr>
	            <td><span>Device</span></td>
	            <td>
	            	<input class="easyui-textbox" name="deviceDesc" style="width: 200px" readonly="true"> 
	            </td>
            </tr>
            <tr>
            <td><span>Input Date</span></td>
             <td> 
               <input name="inputDt" type="text" class="easyui-datetimebox"  >  
             </td>
            </tr>
            <tr >
	            <td><span>Door Distance</span></td>
	            <td>
	            	  <input class="easyui-textbox" name="doorDistance" style="width: 200px" required="required">
	            </td>
            </tr>
            <tr>
	             <td><span>Door Status</span></td>
	             <td>
	            	<select id="doorStatus" class="easyui-combobox" name="doorStatus" style="width:200px;">
				    <option value="Close">Close</option>
				    <option value=Open">Open</option> 
					</select> 
	             </td>
            </tr> 
            <tr>
            	<td><span>Signal Power</span></td>
             	<td>
            		<input class="easyui-textbox" name="nbSignalPwr" style="width: 200px">
             	</td>
            </tr>
            <tr>
            <td><span>Battary Vol</span></td>
             <td> 
                <input class="easyui-textbox" name="battVol" style="width: 200px"> 
             </td>
            </tr>
            
            <tr>
            <td><span>Check Status  </span></td>
             <td>  
                <select id="isStaffCheck" class="easyui-combobox" name="isStaffCheck" style="width:200px;">
				    <option value="T">T</option>
				    <option value="F">F</option> 
				</select> 
             </td>
            </tr>
            <tr>
            <td><span>Staff</span></td>
             <td> 
               <input name="staffno" type="text" class="easyui-textbox"  >  
             </td>
            </tr>
            </table>    
            
        </form>
        <div style="text-align: center; padding: 5px 0;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
                onclick="updateForm()" style="width: 80px" id="tt">Submit</a> 
        </div>
    </div>
          <!-- 配置增加框 -->
    <div id="addUser" class="easyui-dialog" title="Add User Information"
        style="width: 400px; height: 450px;" data-options="modal:true">
        
        <form id="addUserForm" method="post">
           
                </br>
          <table class="main">
           
            <tr>
	            <td><span>Device ID</span></td>
	            <td>
	            	<input class="easyui-textbox" name="deviceId" style="width: 200px" > 
	            </td>
            </tr>
            <tr>
            <td><span>Input Date</span></td>
             <td> 
               <input name="inputDt" type="text" class="easyui-datetimebox"  style="width: 200px">  
             </td>
            </tr>
            <tr >
	            <td><span>Door Distance</span></td>
	            <td>
	            	  <input class="easyui-textbox" name="doorDistance" style="width: 200px" required="required">
	            </td>
            </tr>
            <tr>
	             <td><span>Door Status</span></td>
	             <td>
	            	
	            	 <select id="doorStatus" class="easyui-combobox" name="doorStatus" style="width:200px;">
					    <option value="Close">Close</option>
					    <option value="Open">Open</option> 
					 </select> 
	             </td>
            </tr> 
            <tr>
            	<td><span>Signal Power</span></td>
             	<td>
            		<input class="easyui-textbox" name="nbSignalPwr" style="width: 200px">
             	</td>
            </tr>
            <tr>
            <td><span>Battary Vol</span></td>
             <td> 
                <input class="easyui-textbox" name="battVol" style="width: 200px"> 
             </td>
            </tr>
            
            <tr>
            <td><span>Check Status</span></td>
             <td>  
                <select id="isStaffCheck" class="easyui-combobox" name="isStaffCheck" style="width:200px;">
				    <option value="T">T</option>
				    <option value="F">F</option> 
				</select> 
             </td>
            </tr>
            <tr>
            <td><span>Staff</span></td>
             <td> 
               <input name="staffno" type="text" class="easyui-textbox"  >  
             </td>
            </tr>
            </table>    
          
        </form>
        
        <div style="text-align: center; padding: 5px 0;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
                onclick="addForm()" style="width: 80px" id="tt">submit</a> 
        </div>
    </div>
	
</body>
</html>