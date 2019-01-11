<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 

<%@page import="net.sf.json.JSONArray"%> 
<%@page import="java.util.*"%> 
<%@page import="org.codehaus.jackson.map.ObjectMapper"%> 
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title> 
<!--  
<link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/icon.css"> 
<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script> 
<script type="text/javascript" src="${ctx}/easyui/jquery.easyui.min.js"></script> 

-->
<link rel="stylesheet" type="text/css" href="${ctx}/easyui/1.3.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/wu.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/icon.css" />
<%-- 
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script> 
--%>

<script type="text/javascript" src="${ctx}/easyui/1.3.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/easyui/1.3.4/locale/easyui-lang-en.js"></script>


<script type="text/javascript">var ctx = "${ctx}"</script>	

<script>
        $(function(){
            var p = $('body').layout('panel','west').panel({
                onCollapse:function(){
                    alert('collapse');
                }
            });
        });

        function addTab(title,url){
            //判断窗口是否已经打开,打开了就不再打开
            if ($('#tt').tabs('exists',title)){
                //已经打开不再打开
                $('#tt').tabs('select',title)
                return ;
            }
            $('#tt').tabs('add',{
                title:title,
                content:"<iframe src='"+url+"' style='width:100%;height:100%'  />",
                closable:true,
            });
        }
    </script>
 
</head>
<body class="easyui-layout">
<!-- begin of header -->
	<div class="wu-header" data-options="region:'north',border:false,split:true">
    	<div class="wu-header-left">
        	<h1>Web Admin</h1>
        </div>
        <div class="wu-header-right">
        	<p>Welcome,<strong class="easyui-tooltip" title="unread message">${sessionScope.userInfo }</strong>！</p>
            <p><a href="${ctx}/home.html">Home</a>|<a href="#">Search</a>|<a href="#">Help</a>|<a href="#">Log out</a></p>
        </div>
    </div>
    <!-- end of header -->
    <!--
    <div region="north" border="false" style="height:75px;background:#B3DFDA;padding:10px"><h1>IoT MANAGEMENT SYSTEM</h1></div>
    -->
    <div region="west" split="true" title="MENU" style="width:150px;">
    <!--  
            <div id="aa" class="easyui-accordion" fit="true">
            
             ${sessionScope.access.authorityId }
            <c:if test="${sessionScope.access.authorityId eq '1' }">
            <div title="USER CENTER" iconCls="icon-pencil" style="overflow:auto;padding:10px;">
           
                <a href="javascript:void(0)" onclick="addTab('USER','${ctx}/index/userlist.do')">USER</a>
                <br>
                <a href="javascript:void(0)" onclick="addTab('ROLE','${ctx}/role/rolelist.do')">ROLE</a>
            </div>
            </c:if>
            <div title="DEVICE DETAIL" iconCls="icon-pencil" selected="true" collapsed="true">
                <a href="javascript:void(0)" onclick="addTab('DEVICE','${ctx}/device/find.do')">device1</a>
                <br>
                <a href="javascript:void(0)" onclick="addTab('DEVICE','${ctx}/device/list.do')">device2</a>
          
            </div>
            <div title="TEST" iconCls="icon-pencil" style="padding:10px;">
                 <a href="javascript:void(0)" onclick="addTab('manu','${ctx}/menu/find.do')">menu1</a>
          
            </div>
            
        -->    
            <ul class="easyui-tree wu-side-tree">
    			
                 	 
                    
                    <li iconCls="icon-users">
                    	<a href="javascript:void(0)" data-icon="icon-users" onclick="addTab('USER','${ctx}/index/userlist.do')">用户管理</a>
                    <!--  <a href="javascript:void(0)" data-icon="icon-user-group" data-link="${ctx}/index/user.do" iframe="0">用户管理</a>-->
                    </li>
                    <li iconCls="icon-user-group">
                 	 <a href="javascript:void(0)" data-icon="icon-users" onclick="addTab('ROLE','${ctx}/role/rolelist.do')">角色管理</a>
                 	 <!-- 
                 	 <a href="javascript:void(0)" data-icon="icon-user-group" data-link="${ctx}/role/list.do" iframe="0">角色管理</a>
                 	 <a href="javascript:void(0)" data-icon="icon-cog" data-link="${ctx}/device/list.do" iframe="0">设备管理</a>
                     <a href="javascript:void(0)" data-icon="icon-users" data-link="${ctx}/index/userlist.do" iframe="0">旧用户管理</a> 
                 	 -->
                 	 </li>
                    
                    <li iconCls="icon-cog">
                    <a href="javascript:void(0)" data-icon="icon-users" onclick="addTab('设备管理','${ctx}/device/list.do')">设备管理</a></li>
                    <li iconCls="icon-book">
                    <a href="javascript:void(0)" data-icon="icon-users" onclick="addTab('设备数据记录','${ctx}/device/dtl/list.do')">设备数据记录</a></li>
                    <li iconCls="icon-book">
                    <a href="javascript:void(0)" data-icon="icon-users" onclick="addTab('车位数据记录','${ctx}/carsensor/dtl/list.do')">车位数据记录</a></li>
                    
                   <!--  
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="${ctx}/index/userlist.do" iframe="0">导航标题</a></li>
                    <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="${ctx}/role/rolelist.do" iframe="0">导航标题</a></li>
                    <li iconCls="icon-user-group"><a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">导航标题</a></li>
                    <li iconCls="icon-book"><a href="javascript:void(0)" data-icon="icon-book" data-link="temp/layout-3.html" iframe="0">导航标题</a></li>
                    <li iconCls="icon-cog"><a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">导航标题</a></li>
                    <li iconCls="icon-application-osx-error"><a href="javascript:void(0)" data-icon="icon-application-osx-error" data-link="temp/layout-3.html" iframe="0">导航标题</a></li>
               		
               		
               		
	    			 <a href="javascript:void(0)" onclick="addTab('user','${ctx}/index/userlist.do')">USER</a>
	                <br>
	                <a href="javascript:void(0)" onclick="addTab('role','${ctx}/role/rolelist.do')">ROLE</a>
               		-->
                </ul>
    </div>
    </div>
    <div region="center" >
        <div id="tt" class="easyui-tabs" tools="#tab-tools" fit="true">
            <%-- <div title="Main" tools="#p-tools" style="padding:20px;" >
                <h2><font color="gray">Welcome to Iot Backend</font></h2>
                <c:if test="${sessionScope.access.authorityId eq '1' }">
                Super Admin
                </c:if> 
                <div title="首页" data-options="href:'${ctx}/temp/layout-1.html',closable:false,iconCls:'icon-tip',cls:'pd3'"></div>
            </div> --%>
             <div title="首页" data-options="href:'${ctx}/temp/layout-1.html',closable:false,iconCls:'icon-tip',cls:'pd3'"></div>
         
        </div>
    </div>
 <!-- begin of footer -->
	<div class="wu-footer" data-options="region:'south',border:true,split:true">
    	&copy; 2018 Iot All Rights Reserved
    </div>
    <!-- end of footer -->  
</body>
</html>