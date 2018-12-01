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
<link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/icon.css"> 
<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script> 
<script type="text/javascript" src="${ctx}/easyui/jquery.easyui.min.js"></script> 

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
    <div region="north" border="false" style="height:75px;background:#B3DFDA;padding:10px"><h1>IoT MANAGEMENT SYSTEM</h1></div>
    <div region="west" split="true" title="MENU" style="width:150px;">
            <div id="aa" class="easyui-accordion" fit="true">
            <!-- super admin -->
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
    </div>
    </div>
    <div region="center" >
        <div id="tt" class="easyui-tabs" tools="#tab-tools" fit="true">
            <div title="Main" tools="#p-tools" style="padding:20px;" >
                <h2><font color="gray">Welcome to Iot Backend</font></h2>
                <c:if test="${sessionScope.access.authorityId eq '2' }">
                Super Admin
                </c:if>
            </div>
        </div>
    </div>
 
</body>
</html>