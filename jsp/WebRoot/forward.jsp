<jsp:directive.page language="java" contentType="text/html; charset=utf-8" />
<jsp:directive.page trimDirectiveWhitespaces="false" />
<jsp:directive.page import="java.util.Date"/>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="java.util.ArrayList"/>
<%
	out.clear();
	if("1".equals(request.getParameter("param"))){
%>
<jsp:forward page="/somepage.jsp">
	<jsp:param name="param1" value="value1"/>
	<jsp:param name="param2" value="value2"/>
</jsp:forward>
<%
	}
%>
<html>
<head>
<title>计数器</title>
<link rel='stylesheet' type='text/css' href='css/style.css'>
</head>
<body> 
i请使用地址栏参数 param=1 访问该页面。 
</body>
</html>

