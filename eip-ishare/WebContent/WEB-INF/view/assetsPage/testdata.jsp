<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<%@page import="net.sf.json.JSONArray"%> 
<%@page import="java.util.*"%> 
<%@page import="org.codehaus.jackson.map.ObjectMapper"%> 
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title> 
 
</head>
<body>

<% 
//String json = "{\"firstname\":\"firstname\",\"lastname\":\"lastname\",\"phone\":123456,\"email\":\"281446883@qq.com\"}"; 
List<Map<String,String>> list = new ArrayList<Map<String,String>>(); 
Map<String,String> user1 = new HashMap<String,String>(); 
user1.put("firstname", "name1"); 
user1.put("lastname", "name2"); 
user1.put("phone", "1234"); 
user1.put("email", "281446888@qq.com"); 
list.add(user1); 

Map<String,String> user2 = new HashMap<String,String>(); 
user2.put("firstname", "name2"); 
user2.put("lastname", "name4"); 
user2.put("phone", "1234"); 
user2.put("email", "281446888@qq.com"); 
list.add(user2); 

JSONArray jsonArray = JSONArray.fromObject(list); 
System.out.println(jsonArray.toString()); 
Map<String,Object> map = new HashMap<String,Object>(); 
map.put("total", 1); 
map.put("rows", jsonArray); 

ObjectMapper objMap = new ObjectMapper(); 
objMap.writeValue(response.getWriter(), map); 
//System.out.println(json); 
%> 
	 
</body>
</html>