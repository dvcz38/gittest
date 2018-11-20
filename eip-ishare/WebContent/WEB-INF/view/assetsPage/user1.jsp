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
</head>
<body>

	<table id="dg" title="My Users" class="easyui-datagrid" style="width:500px;height:250px" 
url="${ctx}/index/finduser.do" toolbar="#toolbar" rownumbers="true" fitColumns="true" singleSelect="true"> 
<thead> 
<tr> 
<th field="firstname" width="50">First Name</th> 
<th field="lastname" width="50">Last Name</th> 
<th field="phone" width="50">Phone</th> 
<th field="email" width="50">Email</th> 
</tr> 
</thead> 
</table> 
</body>
</html>