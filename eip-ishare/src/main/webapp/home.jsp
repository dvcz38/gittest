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

<!-- Required Stylesheets -->
<link rel="stylesheet" type="text/css" href="./css/yu/reset.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./css/yu/text.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./css/yu/fonts/ptsans/stylesheet.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./css/yu/fluid.css" media="screen" />

<link rel="stylesheet" type="text/css" href="./css/yu/mws.style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./css/yu/icons/icons.css" media="screen" />

<!-- Demo and Plugin Stylesheets -->
<link rel="stylesheet" type="text/css" href="./css/yu/demo.css" media="screen" />

<link rel="stylesheet" type="text/css" href="./plugins/colorpicker/colorpicker.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./plugins/jimgareaselect/css/imgareaselect-default.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./plugins/fullcalendar/fullcalendar.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./plugins/fullcalendar/fullcalendar.print.css" media="print" />
<link rel="stylesheet" type="text/css" href="./plugins/tipsy/tipsy.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./plugins/sourcerer/Sourcerer-1.2.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./plugins/jgrowl/jquery.jgrowl.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./plugins/spinner/spinner.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./css/yu/jui/jquery.ui.css" media="screen" />
 

<!-- Theme Stylesheet -->
<link rel="stylesheet" type="text/css" href="./css/yu/mws.theme.css" media="screen" />
<link rel="stylesheet" type="text/css" href="./css/yu/ly.css" media="screen">

<!-- JavaScript Plugins --> 

<!-- JavaScript Plugins -->

<script type="text/javascript" src="./js/yu/jquery-1.7.1.min.js"></script>

<script type="text/javascript" src="./plugins/jimgareaselect/jquery.imgareaselect.min.js"></script>
<script type="text/javascript" src="./plugins/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript" src="./plugins/jgrowl/jquery.jgrowl.js"></script>
<script type="text/javascript" src="./plugins/jquery.filestyle.js"></script>
<script type="text/javascript" src="./plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript" src="./plugins/jquery.dataTables.js"></script>

 <script type="text/javascript" src="./plugins/colorpicker/colorpicker.js"></script>
<script type="text/javascript" src="./plugins/tipsy/jquery.tipsy.js"></script>
<script type="text/javascript" src="./plugins/sourcerer/Sourcerer-1.2.js"></script>
<script type="text/javascript" src="./plugins/jquery.placeholder.js"></script>
<script type="text/javascript" src="./plugins/jquery.validate.js"></script>
<script type="text/javascript" src="./plugins/jquery.mousewheel.js"></script>
<script type="text/javascript" src="./plugins/spinner/ui.spinner.js"></script>
<script type="text/javascript" src="./js/yu/jquery-ui.js"></script>
 
 
<script type="text/javascript" src="./js/yu/mws.js"></script>
<script type="text/javascript" src="./js/yu/demo.js"></script>
<script type="text/javascript" src="./js/yu/themer.js"></script>

<!-- <script type="text/javascript" src="./js/yu/demo.dashboard.js"></script> -->
<script type="text/javascript" src="./js/yu/highcharts.js"></script>

<script type="text/javascript" src="./js/yu/ly-charts.js"></script>
<script type="text/javascript" src="./js/yu/ly-charts2.js"></script>
<script type="text/javascript" src="./js/yu/ly.js"></script>
 
<title>Home</title>

</head>
 <body>

	<!-- Themer -->  
	<div id="mws-themer">
    	<div id="mws-themer-hide"></div>
        <div id="mws-themer-content">
        	<div class="mws-themer-section">
	        	<label for="mws-theme-presets">Presets</label> <select id="mws-theme-presets"></select>
            </div>
            <div class="mws-themer-separator"></div>
            <div class="mws-themer-section">
                <ul>
                    <li><span>Base Color</span> <div id="mws-base-cp" class="mws-cp-trigger"></div></li>
                    <li><span>Text Color</span> <div id="mws-text-cp" class="mws-cp-trigger"></div></li>
                    <li><span>Text Glow Color</span> <div id="mws-textglow-cp" class="mws-cp-trigger"></div></li>
                </ul>
            </div>
            <div class="mws-themer-separator"></div>
            <div class="mws-themer-section">
            	<ul>
                    <li><span>Text Glow Opacity</span> <div id="mws-textglow-op"></div></li>
                </ul>
            </div>
            <div class="mws-themer-separator"></div>
            <div class="mws-themer-section">
	            <button class="mws-button red small" id="mws-themer-getcss">Get CSS</button>
            </div>
        </div>
        <div id="mws-themer-css-dialog">
        	<div class="mws-form">
            	<div class="mws-form-row" style="padding:0;">
		        	<div class="mws-form-item">
                    	<textarea cols="auto" rows="auto" readonly="readonly"></textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Themer End -->
    

	<!-- Header Wrapper -->
	<div id="mws-header" class="clearfix">
    
    	<!-- Logo Wrapper -->
    	<div id="mws-logo-container">
        	<div id="mws-logo-wrap">
            	<!-- <img src="images/mws-logo.png" alt="mws admin" /> -->
			</div>
        </div>
        
        <!-- User Area Wrapper -->
        <div id="mws-user-tools" class="clearfix">
        
        	
            
            <!-- User Functions -->
            <div id="mws-user-info" class="mws-inset">
            	<div id="mws-user-photo">
            	<!--  
                	<img src="example/profile.jpg" alt="User Photo" />
                	-->
                </div>
                <div id="mws-user-functions">
                    <div id="mws-username">
                        Hello, Admin
                    </div>
                    <ul>
                    	<!-- 
                    	<li><a href="#">Profile</a></li>
                        <li><a href="#">Change Password</a></li>
                         -->
                        <li><a href="logout.jsp">Logout</a></li>
                    </ul>
                </div>
            </div>
            <!-- End User Functions -->
            
        </div>
    </div>
    
    <!-- Main Wrapper -->
    <div id="mws-wrapper">
        
        <!-- Container Wrapper -->
        <div id="mws-container" class="clearfix">
        
        	<!-- Main Container -->
            <div class="container">
                
            	<div class="mws-panel grid_4 ly-shadow">
                	<div class="mws-panel-header">
                    	<span class="mws-i-24 i-graph">Charts
                           <select class="nbSignalPwr">
                                
                           </select>
                        </span>

                    </div>
                    <div class="mws-panel-body">
                    	<div class="mws-panel-content">
	                    	<div id="ly-chart1" style="width:100%; height:215px;"></div>
                        </div>
                    </div>
                </div>
                <div class="mws-panel grid_4 ly-shadow">
                    <div class="mws-panel-header">
                        <span class="mws-i-24 i-graph">Charts
                           <select class="doorDistance">
                                
                           </select>
                        </span>
                    </div>
                    <div class="mws-panel-body">
                        <div class="mws-panel-content">
                            <div id="ly-chart2" style="width:100%; height:215px;"></div>
                         
                        </div>
                    </div>
                </div>
                
                <div class="mws-report-container clearfix">
                    <a class="mws-report ly-shadow" href="#">
                        <span class="mws-report-icon mws-ic ic-monitor"></span>
                        <span class="mws-report-content">
                            <span class="mws-report-title">Equipment Number</span>
                            <span class="mws-report-value">324</span>
                        </span>
                    </a>

                    <a class="mws-report ly-shadow" href="#">
                        <span class="mws-report-icon mws-ic ic-light-circle-green"></span>
                        <span class="mws-report-content">
                            <span class="mws-report-title">Equipment without occlusion</span>
                            <span class="mws-report-value">74</span>
                        </span>
                    </a>

                    <a class="mws-report ly-shadow" href="#">
                        <span class="mws-report-icon mws-ic ic-layer-remove"></span>
                        <span class="mws-report-content">
                            <span class="mws-report-title">Equipment occlusion</span>
                            <span class="mws-report-value">14</span>
                        </span>
                    </a>
                    
                    <a class="mws-report ly-shadow" href="#">
                        <span class="mws-report-icon mws-ic ic-delete"></span>
                        <span class="mws-report-content">
                            <span class="mws-report-title">Equipment loss</span>
                            <span class="mws-report-value">22</span>
                        </span>
                    </a>
                    
                </div>



            	<div class="mws-panel grid_4 ly-shadow">
                	<div class="mws-panel-header">
                    	<span class="mws-i-24 i-books-2 ly-time">Automatic inspection<i>1030</i> <a>more</a></span>
                    </div>
                    <div class="mws-panel-body">
                        <ul class="mws-summary ly-auto">
                           <!--  <li>
                                <span>20:15</span> 1/301-deviceone-20%-state
                             
                            </li>
                            <li>
                                <span>20:15</span> 1/301-deviceone-20%-state
                             
                            </li> -->
                            
                           
                        </ul>
                    </div>
                </div>
                <div class="mws-panel grid_4 ly-shadow">
                    <div class="mws-panel-header">
                        <span class="mws-i-24 i-books-2 ly-time">Manual  inspection  <i>1030</i> <a>more</a></span>
                    </div>
                    <div class="mws-panel-body">
                        <ul class="mws-summary ly-human">
                            <!-- <li>
                                <span>20:15</span> 1/301-deviceone-20%-state-name
                            </li> -->
                            
                        </ul>
                    </div>
                </div>
                
                
                
            <!-- End Main Container -->
            
            
            
        </div>
        <!-- End Container Wrapper -->
        
    </div>
    <!-- End Main Wrapper -->


</body>
</html>