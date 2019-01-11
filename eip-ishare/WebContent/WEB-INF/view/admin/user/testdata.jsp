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
<title>用户列表</title>

    <link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/icon.css">
    <script type="text/javascript" src="${ctx}/easyui/jquery.min.js" ></script>
    <script type="text/javascript" src="${ctx}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${ctx}/easyui/locale/easyui-lang-zh_CN.js"></script>
    
    

    <script type="text/javascript">
    var ctx="${ctx}";
    var ws = null ;
    //var target="ws://localhost:8080/${ctx}/sockjs/vwebSocketServer.do/info?type=mall";
    <!--
     
    -->
    if ('WebSocket' in window) {
    	 //ws = new WebSocket("ws://127.0.0.1:8080/eip-ishare/deviceinfows.do");
         ws = new WebSocket("ws://127.0.0.1:8080/eip-ishare/websocket.do");
    	 //ws = new WebSocket("ws://127.0.0.1:8080/eip-ishare/ws.do");
    	 //ws = new WebSocket("ws://127.0.0.1:8080/eip-ishare/carsensordtlws.do");
    	 
    	 // ws = new WebSocket("ws://18.191.197.106:8080/eip-ishare/ws.do");
    	 //ws = new WebSocket("ws://18.191.197.106:8080/eip-ishare/carsensordtlws.do"); 
    	 
    	
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://127.0.0.1:8080/"+ctx+"/websocket.do");
    } else {
        ws = new SockJS("ws://127.0.0.1:8080/"+ctx+"/sockjs/websocket.do/info?type=mall");
    }
    /* if ('WebSocket' in window) {
        ws = new WebSocket(target);
    } else if ('MozWebSocket' in window) {
        ws = new MozWebSocket(target);
    } else {
        alert('WebSocket is not supported by this browser.');
    } */
 
    ws.onopen = function(){
        console.info('open') ;
       
    } ;
    
    ws.onclose = function ( ) {
        console.info('close') ;
        
    } ;
    ws.onmessage = function(event){
        console.info("onmessage") ;
      //  location.reload();
        view(event.data)
    } ;
    function q(){
    	ws.send(document.getElementById('msg').value);
    }
    
    function view(data){
    	
    	var a = data;
    	var obj=JSON.parse(data);
		//console.log(obj.loss[0].deviceDesc);
		$("#view").add("p").append(obj.battVol);
    	 
    }
 
   /*  $(function(){
        //按钮单击时执行
        $("#testAjax").click(function(){
           
               
               $('#dg').datagrid({   
                  // url:'${ctx}/index/finduser.do',
                   url:'${ctx}/device/find.do',
                   title:"test",
                   pagination:true,
                   columns:[[    
                       // {field:'checked',checkbox:true,width:100},
                       {field:'id',title:'ID',width:100},    
                       {field:'deviceId',title:'Device Id',width:100},    
                       {field:'deviceDesc',title:'Device Name',width:100}    
                   ]],
               }); 
         }); 
        
        
        $("#testAjax1").click(function(){
        	   //取Ajax返回结果
            //为了简单，这里简单地从文件中读取内容作为返回数据
            //htmlobj=$.ajax({url:"${ctx}/easyui/readme.txt",async:false});
            htmlobj=$.ajax({url:"${ctx}/device/find.do",async:false});
             //显示Ajax返回结果
             $("#myDiv").html(htmlobj.responseText);
        }); 
    });*/
	</script>
</head>
<body class="easyui-layout">

服务器返回的信息：
<input type="text" id="show"/>
 
浏览器发送的信息：
<input type="text" id="msg"/>
<input type="button" value="send" id="send" onclick="q()"/>
<div id="view"></div>
<div >
     <table id="dg"></table>
 	<table id="dg1" ></table>
</div>
1
	 <div id="myDiv"><h2>通过 AJAX 改变文本</h2></div>
        <button id="testAjax" type="button">Ajax改变内容</button>
        <button id="testAjax1" type="button">tttt</button>
</body>
</html>