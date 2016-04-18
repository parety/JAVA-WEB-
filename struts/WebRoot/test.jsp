<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <jsp:include flush="true" page="/header.jsp"></jsp:include>
    
    <table>
    	<tr>
    		<td><jsp:include flush="true" page="/left.jsp" /> </td>
    		<td><jsp:include flush="true" page="/main.jsp" /></td>
    	</tr>
    </table>
    
    <jsp:include flush="true" page="/footer.jsp"></jsp:include>
  </body>
</html>
