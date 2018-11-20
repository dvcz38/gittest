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
<title>用户管理</title>
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
 
	 <script type="text/javascript" src="${ctx}/javascript/device/device.js"></script> 
	<script type="text/javascript">var ctx = "${ctx}"</script>	
</head>



<body class="easyui-layout">


	
<div id="deviceInfoManage_toolbar" style="display: none;">
	<table>
		<tr>
			<td>
				<form action="${ctx}/device/find.do" method="post">
					<table>
						<tr>
                            <td>User Name：</td>
                            <td><input id="name" type="text" class="col-sm-2"></td>
                            <td><div class="datagrid-btn-separator"></div></td>
                            <!--  
                            <td>Tel Number：</td>
                            <td><input name="email" class="col-sm-2"/></td>
                            <td><div class="datagrid-btn-separator"></div></td>
                            -->
                            <td>Email：</td>
                            <td><input id="email" class="col-sm-2"/></td>
                            <td>
                          
                                <a id="deviceManage_toolbar_search" href="javascript:void(0);"
                                   class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">Enquire</a>
                                <div class="datagrid-btn-separator"></div>
                                <a id="deviceManage_toolbar_cleanSearch" href="javascript:void(0);"
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
                             <!--   <a href="javascript:;" onClick="excel()" id="exId">导出 -->
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
	</table>
</div>


<div id="deviceInfoManage_layout_center" data-options="region:'center',border:false" style="overflow: hidden;">
    <table id="deviceInfoManage_datagrid"><tr></tr></table>
</div>

<!--  
<div id="deviceInfoManage_layout_south" data-options="region:'south',border:false" style="overflow: hidden; height: 30px">
    <div id="deviceInfoManage_pagination" style="background: #efefef; border: 1px solid #ccc;"></div>
</div>
-->

	
</body>
</html>