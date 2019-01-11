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
<title>Role List</title>

<link rel="stylesheet" type="text/css" href="${ctx}/easyui/1.3.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/wu.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/icon.css" />

<script type="text/javascript" src="${ctx}/easyui/1.3.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>

	<script type="text/javascript" src="${ctx}/javascript/userPage/rolelist.js"></script> 
	<script type="text/javascript">var ctx = "${ctx}"</script>	
</head>



<body class="easyui-layout">
 


<div id="userInfoManage_layout_center" data-options="region:'center',border:false" style="overflow: hidden;">
    <table id="userInfoManage_datagrid"><tr></tr></table>
</div>

 
<!-- 配置修改框面板 -->
<!-- 
<div id="wu-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
 -->
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
            	   <select id="isRead" class="easyui-combobox" name="isRead" style="width:200px;">
				    <option value="Y">READ</option>
				    <option value="N">CANT READ</option> 
				</select> 
             </td>
            </tr>
              <tr>
             <td><span>Add</span></td>
             <td> 
            	   <select id="isAdd" class="easyui-combobox" name="isAdd" style="width:200px;">
				    <option value="Y">ADD</option>
				    <option value="N">CANT ADD</option> 
				</select> 
             </td>
            </tr>
            <tr>
            	<td><span>Delete</span></td>
             	<td> 
            		<select id="isDelete" class="easyui-combobox" name="isDelete" style="width:200px;">
				    <option value="Y">DELETE</option>
				    <option value="N">CANT DELETE</option> 
				    </select> 
             	</td>
            </tr>
            <tr>
            <td><span>Edit</span></td>
             <td>  
                <select id="isEdit" class="easyui-combobox" name="isEdit" style="width:200px;">
				    <option value="Y">EDIT</option>
				    <option value="N">CANT EDIT</option> 
				</select> 
             </td>
            </tr>
            <tr>
            <td><span>Export</span></td>
             <td> 
               <select id="isDownload" class="easyui-combobox" name="isDownload" style="width:200px;">
				    <option value="Y">DOWNLOAD</option>
				    <option value="N">CANT DOWNLOAD</option> 
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
         
</body>
</html>