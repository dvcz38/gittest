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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${ctx}/assets-js/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets-js/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="${ctx}/assets-js/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx}/assets-js/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${ctx}/assets-js/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="${ctx}/assets-js/css/style.css"/>
<title>Login</title>

</head>
<body class="login-layout">
<div class="logintop">    
    <span>IoT Backend Management System</span>    
    <ul>
    <li><a href="#">Home</a></li>
    <li><a href="#">Help</a></li>
    <li><a href="#">About Us</a></li>
    </ul>    
    </div>
    <div class="loginbody">
<div class="login-container">
	<div class="center">
		<h1>
			<i class="icon-leaf green"></i>
			<span class="orange">IoT</span>
			<span class="white"> Management System</span>
		</h1>
		<!-- 
		 <h4 class="white">Background Management System</h4>
		-->
	</div>

	<div class="space-6"></div>

	<div class="position-relative">
		<div id="login-box" class="login-box widget-box no-border visible">
			<div class="widget-body">
				<div class="widget-main">
					<h4 class="header blue lighter bigger">
						<i class="icon-coffee green"></i>
						System Login
					</h4>

		<div class="login_icon"><img src="${ctx}/assets-js/images/login.png" /></div>
		<form class="">
				<fieldset>
					<label class="block clearfix">
						<span class="block input-icon input-icon-right">
							<input id="userId" type="text" class="form-control" placeholder="username"  name="username" value="admin">
							<i class="icon-user"></i>
						</span>
					</label>
	
					<label class="block clearfix">
						<span class="block input-icon input-icon-right">
							<input id="pswId" type="password" class="form-control" placeholder="password" name="password" value="admin">
							<i class="icon-lock"></i>
						</span>
					</label>
	
					<div class="space"></div>
	
					<div class="clearfix">
						<label class="inline">
							<input type="checkbox" class="ace">
							<span class="lbl">save password</span>
						</label>
	
						<button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="login_btn">
							<i class="icon-key"></i>
							Submit
						</button>
					</div>
	
					<div class="space-4"></div>
				</fieldset>
			</form>

				<div class="social-or-login center">
					<span class="bigger-110">Notice</span>
				</div>

				<div class="social-login center">
					support IE8 or above
				</div>
			</div>

				<div class="toolbar clearfix">
					
				</div>
			</div>
		</div>
	</div>
	
	</div>
</div>
<div class="loginbm">Powered by <a href="">IoT 2018</a> </div><strong></strong>	

<script src="${ctx}/assets-js/assets/js/ace-extra.min.js"></script>
<script src="${ctx}/assets-js/js/jquery-1.9.1.min.js"></script>        
<script src="${ctx}/assets-js/assets/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/javascript/login/login.js"></script>
<script type="text/javascript">var ctx = "${ctx}"</script>
</body>
</html>