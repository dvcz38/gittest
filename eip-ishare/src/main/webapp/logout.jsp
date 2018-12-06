<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> 
<%@ page isELIgnored="false"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head> 
<title>logout</title>

<script language="javascript">
   function quit(){
    if(confirm("sure to logout?")){
     window.location.href="logout.jsp";
    }
   }
</script>
</head>
<body>
<h1>welcome back again</h1>
<%
	session.invalidate();
// out.println("<script language='javascript'>");
// out.println("window.location.href='login.jsp'");
// out.println("</script>"); 
%> 
<a href="login.jsp" onClick="quit()" class="word_white">quit</a>
</body>
</html> 