<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><tiles:getAsString name="title" /> </title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		body {margin: 0px; }
		div, td {font-size: 12px; }
		.banner {
			height: 80px; 
			background: url(${ pageContext.request.contextPath }/images/bg.jpg); 
			font-size: 16px; 
			font-weight: bold; 
			color: #ffffff; 
			padding-top: 30px; 
			padding-left: 40px; 
		}
		.header {
			line-height: 25px; 
			text-align: right; 
			padding-right: 20px; 
			background: url(images/bg_menu.jpg); 
		}
		.header a {color: #293C83; }
		.menu {}
		.menu div{background: #C8D7E3; text-align: center; line-height: 22px; border-bottom: 1px solid #FFFFFF; }
		.menu div a{color: #293D6B; }
		.menu #selected{background: #98B1C4; }
		.menu #selected a {color: #ffffff; }
		.footer {color: #ffffff; background: #98B1C4; line-height: 23px; text-align: center; }
	</style>
  </head>
  
  <body>
    <div class="banner"><tiles:getAsString name="title" /></div>
    <div class="header">
    	<tiles:getAsString name="header"/>
    </div>
    
    <table>
    	<tr>
    		<td width=136 class="menu">
    			<tiles:getAsString name="menu" />
    			<div align=right><img src="images/left-nav-corner.gif"></div>
    			<br/><br/><br/><br/><br/><br/>
    		</td>
    		<td valign=top class="main"><tiles:getAsString name="main" /></td>
    	</tr>
    </table>
    
    <div class="footer">
    	<tiles:insert attribute="copyright"></tiles:insert>
    </div>
    
  </body>
</html>
