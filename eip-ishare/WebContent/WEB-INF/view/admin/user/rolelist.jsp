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
<title>ROLE MANAGEMENT</title>
<link rel="stylesheet" href="${ctx}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${ctx}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${ctx}/bootstrap3/js/bootstrap.min.js"></script>
<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/black/easyui.css">	
<link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/IconExtension.css">
<link rel="stylesheet" type="text/css" href="${ctx}/easyui/demo/demo.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/user/user.css">
<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="${ctx}/easyui/jquery.cookie.js"></script>
	<!-- <script type="text/javascript" src="${ctx}/javascript/indexPage/index.js"></script>
	<script type="text/javascript" src="${ctx}/javascript/userPage/user.js"></script>
	<script type="text/javascript" src="${ctx}/javascript/userPage/editor.js"></script>
	
	 
	 -->
	 <script type="text/javascript" src="${ctx}/javascript/userPage/rolelist.js"></script> 
	<script type="text/javascript">var ctx = "${ctx}"</script>	
</head>



<body class="easyui-layout">
 


<div id="userInfoManage_layout_center" data-options="region:'center',border:false" style="overflow: hidden;">
    <table id="userInfoManage_datagrid"><tr></tr></table>
</div>

 
<!-- 配置修改框面板 -->
    <div id="updateUser" class="easyui-dialog" title="Edit User Information"
        style="width: 400px; height: 450px;" data-options="modal:true">
        
        <form id="upUserForm" method="post">
       
        <!--id默认隐藏,这样就不允许修改 -->
        <div style="margin-bottom: 20px;"> 
             
           <input type="hidden" id="authorityId"  name="authorityId" >
              
           
            </div>
            <table class="main">
            <tr >
            <td><span color="red">Role</span></td>
            <td>
            	<input class="easyui-textbox"  name="authorityDesc"  style="color:blue;font-weight:bold;">
            	 
            </td>
            </tr>
            <tr>
             <td><span>Read</span></td>
             <td>
            	 <input type="checkbox" name="isRead" style="width: 200px">
             </td>
            </tr>
             
            <tr>
            	<td><span>Delete</span></td>
             	<td>
            		<input type="checkbox" name="isDelete"  >
             	</td>
            </tr>
            <tr>
            <td><span>Edit</span></td>
             <td> 
                <input type="checkbox" name="isEdit"  > 
             </td>
            </tr>
            <tr>
            <td><span>Export</span></td>
             <td>
               <input name="isDownload" type="checkbox" >  
             </td>
            </tr>
            
            </table>             
            
        </form>
        <div style="text-align: center; padding: 5px 0;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
                onclick="updataForm()" style="width: 80px" id="tt">Submit</a> 
        </div>
    </div>
          <!-- 配置增加框 -->
          <!--  
    <div id="addUser" class="easyui-dialog" title="Add User Information"
        style="width: 400px; height: 450px;" data-options="modal:true">
        
        <form id="addUserForm" method="post">
           
                </br>
           <table class="main">
            <tr>
	            <td><span>User Name</span></td>
	            <td>
	            	<input class="easyui-textbox" name="name" style="width: 200px" required="required"> 
	            </td>
            </tr>
            
            <tr >
	            <td><span>password</span></td>
	            <td>
	            	  <input class="easyui-textbox" name="password" style="width: 200px" required="required">
	            </td>
            </tr>
            <tr>
	             <td><span>Email</span></td>
	             <td>
	            	 <input class="easyui-textbox" name="email" style="width: 200px">
	             </td>
            </tr> 
            <tr>
            	<td><span>Phone Number</span></td>
             	<td>
            		<input class="easyui-textbox" name="phone" style="width: 200px">
             	</td>
            </tr>
            <tr>
            <td><span>Role</span></td>
             <td> 
                <input class="easyui-textbox" name="role" style="width: 200px"> 
             </td>
            </tr>
            <tr>
            <td><span>Join Date</span></td>
             <td> 
               <input name="joindate" type="text" class="easyui-datebox"  >  
             </td>
            </tr>
            <tr>
            <td><span>State</span></td>
             <td>  
                <select id="state" class="easyui-combobox" name="state" style="width:200px;">
				    <option value="1">STATE1</option>
				    <option value="0">STATE2</option> 
				</select> 
             </td>
            </tr>
            </table>    
        </form>
        
        <div style="text-align: center; padding: 5px 0;">
            <a href="javascript:void(0)" class="easyui-linkbutton"
                onclick="addForm()" style="width: 80px" id="tt">submit</a> 
        </div>
    </div>
	-->
</body>
</html>