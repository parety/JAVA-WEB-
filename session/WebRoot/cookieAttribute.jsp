<%@ page language="java" pageEncoding="UTF-8" errorPage="login.jsp" %>
<%

	Cookie[] cc = request.getCookies();
	
	out.println(cc);

	Cookie cookie = new Cookie("password1", "babyface009988");
	
	cookie.setPath(request.getContextPath());

	
	response.addCookie(cookie);
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Cookie</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

</body>
</html>
