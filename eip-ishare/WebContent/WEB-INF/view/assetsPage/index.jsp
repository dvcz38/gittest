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
<title>Iot Management System</title>
	<link rel="stylesheet" href="${ctx}/bootstrap3/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ctx}/bootstrap3/css/bootstrap-theme.min.css">
	<script src="${ctx}/bootstrap3/js/jquery-1.11.2.min.js"></script>
	<script src="${ctx}/bootstrap3/js/bootstrap.min.js"></script>
	<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/black/easyui.css">	
	<link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/easyui/demo/demo.css">
	<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${ctx}/easyui/jquery.cookie.js"></script>
	<script type="text/javascript" src="${ctx}/javascript/indexPage/index.js"></script>
	<script type="text/javascript">var ctx = "${ctx}"</script>
</head>

<!-- easyui-layout边框布局 -->
<body class="easyui-layout">
	<div data-options="region:'north'" split="false" style="overflow: hidden; height: 45px;" >
		<div id="sessionInfoDiv" style="overflow: hidden; height: 45px; background: repeat-x center 50%; line-height: 28px; font-family: Verdana, 微软雅黑,黑体;">
				<span style="padding-left:10px; font-size: 20px; text-align: inherit;">Iot Management System<strong style="font-size: 24px;"></strong></span>
				<div style="float: right;">
				 <span style="margin-left: 55%; color: #B83400; padding-bottom 0px; position: absolute;">0人在线----当前登录用户:admin--【欢迎登录】!</span>
						<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'icon-theme'"><strong>Theme</strong></a>
						<a href="javascript:void(0)" id="menus" class="easyui-menubutton" data-options="iconCls:'icon-user'"><strong>Control Panel</strong></a>	
						<a href="javascript:void(0)" id="exitMenus" class="easyui-menubutton" data-options="iconCls:'icon-2012080412263'"><strong>Login out</strong></a>
						<a href="javascript:void(0)" id="helpMenus" class="easyui-menubutton" data-options="iconCls:'icon-help'"><strong>Help</strong></a>
				</div>
		</div>
	</div>
	<div data-options="region:'west'" title="Menu" split="false" style="width: 200px; overflow: hidden;">
        <!-- 
         <div id="menuCode" class="easyui-accordion" data-options="fit:true,border:false,animate:true,plain:true">
        
  			 
		
			  <ul id="tree" class="easyui-tree">
				 
			  </ul>
			    
         </div>
         -->
         <!--  <div region="west" split="true" title="菜单" style="width:150px;">-->
            <div id="aa" class="easyui-accordion" fit="true">
            <div title="用户管理" iconCls="icon-pencil" style="overflow:auto;padding:10px;">
                <a href="javascript:void(0)" onclick="tab('列表1','${ctx}/index/userlist.do')">用户列表</a>
                <br>
                <a href="javascript:void(0)" onclick="tab('列表2','${ctx}/index/pagemanager.do')">角色列表</a>
            </div>
            <div title="设备管理" iconCls="icon-pencil" selected="true" collapsed="true">
                <a href="javascript:void(0)" onclick="tab('device1','${ctx}/device/find.do')">device1</a>
                <br>
                <a href="javascript:void(0)" onclick="tab('device2','${ctx}/device/pagemanager.do')">device2</a>
          
            </div>
            <div title="联系人管理" iconCls="icon-pencil" style="padding:10px;">
                 <a href="javascript:void(0)" onclick="tab('manu','${ctx}/menu/find.do')">menu1</a>
          
            </div>
   <!-- </div>-->
	</div>
	<div id="centerDiv" data-options="region:'center'" split="false" style="overflow: hidden;">
		<div title="Home Main">
			<span style=" font-size: 24px; font-family: 'Arial'; font-style: inherit;">Welcome Home</span>
		</div>
	</div>
	<div data-options="region:'south'" style="height: 30px;" split="false">
		
	</div>
	
	<div id="menu" style="width: 120px; display: none;">
		<div iconCls="icon-key">
			<a href="javascript:void(0)" class="easyui-linkbutton" style="border: 0px;" onclick="updatePwd()">reset password</a>
		</div>
	</div>
	<div id="layout_north_pfMenu" style="width: 100px; display: none;">
		<div onclick="changeTheme('default');">Default Theme</div>
		<div onclick="changeTheme('black');">Black</div>
		<div onclick="changeTheme('ui-pepper-grinder');">Brown</div>
		<div onclick="changeTheme('ui-dark-hive');">DeepBlack</div>
		<div onclick="changeTheme('ui-cupertino');">LightBlue</div>
		<div onclick="changeTheme('ui-sunny');">Yellow</div>
	</div>
	
	<div id="menu_dialog_updatePwd" style="display: block;">
		
	</div>
	
	<div id="update_Menu">
		
	</div>
	
</body>
</html>