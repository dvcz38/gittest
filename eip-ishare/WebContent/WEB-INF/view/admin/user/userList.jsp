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
	 	
</head>



<body class="easyui-layout">


<!-- 
<div id="userInfoManage_toolbar" style="display: none;">
	<table>
		<tr>
			<td>
				<form action="${ctx}/user/findall.do" method="post">
					<table>
						<tr>
                            <td>User Name：</td>
                            <td><input id="name" type="text" class="col-sm-2"></td>
                            <td><div class="datagrid-btn-separator"></div></td>
                           
                            <td>Email：</td>
                            <td><input id="email" class="col-sm-2"/></td>
                            <td>
                          
                                <a id="userManage_toolbar_search" href="javascript:void(0);"
                                   class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">Enquire</a>
                                <div class="datagrid-btn-separator"></div>
                                <a id="userManage_toolbar_cleanSearch" href="javascript:void(0);"
                                   class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">Reset</a>
                            </td>
                        </tr>
					</table>
				</form>
			</td>
		</tr>
		<tr height="10"><td></td></tr>
		<tr>
            <td>
                <table>
                    <tr>
                        <td><a id="test1Manage_toolbar_add" href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'icon-add',plain:true">Add</a></td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                        <td><a id="test1Manage_toolbar_edit" href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'icon-edit',plain:true">Edit</a></td>
                         <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                           <td><a id="test1Manage_toolbar_export" href="javascript:void(0);" class="easyui-linkbutton"
                               data-options="iconCls:'icon-edit',plain:true" onClick="excel()">Export</a></td>    
                             
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
	</table>
</div>
 -->

<div id="userInfoManage_layout_center" data-options="region:'center',border:false" style="overflow: hidden;">
    <table id="userInfoManage_datagrid"><tr></tr></table>
</div>

<!--  
<div id="userInfoManage_layout_south" data-options="region:'south',border:false" style="overflow: hidden; height: 30px">
    <div id="userInfoManage_pagination" style="background: #efefef; border: 1px solid #ccc;"></div>
</div>
-->
 
<!-- 配置修改框面板 -->
    <div id="updateUser" class="easyui-dialog" title="Edit User Information"
        style="width: 400px; height: 450px;" data-options="modal:true">
        
        <form id="upUserForm" method="post">
       
        <!--id默认隐藏,这样就不允许修改 -->
        <div style="margin-bottom: 20px;"> 
             
           <input type="hidden" id="id"  name="id" >
              
           
            </div>
            <table class="main">
         	<tr>
            <td><span>Join Date</span></td>
             <td> 
               <input name="joindate" type="text" class="easyui-datetimebox"  >  
             </td>
            </tr>
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
               <select id="role" class="easyui-combobox" name="role" style="width:200px;">
				    <option value="3">COMMON</option>
				    <option value="2">ADMIN</option> 
				    <option value="1">SUPER ADMIN</option> 
				</select> 
             </td>
            </tr>
            
            <tr>
            <td><span>State</span></td>
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
            <td><span>Join Date</span></td>
             <td> 
               <input name="joindate" type="text" class="easyui-datetimebox"  >  
             </td>
            </tr>
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
               <select id="role" class="easyui-combobox" name="role" style="width:200px;">
				    <option value="3">COMMON</option>
				    <option value="2">ADMIN</option> 
				    <option value="1">SUPER ADMIN</option> 
				</select> 
             </td>
            </tr>
            
            <tr>
            <td><span>State</span></td>
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
            <a href="javascript:void(0)" class="easyui-linkbutton"
                onclick="addForm()" style="width: 80px" id="tt">submit</a> 
        </div>
    </div>
	
</body>
</html>