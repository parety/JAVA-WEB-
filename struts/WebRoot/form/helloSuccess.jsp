<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html> 
	<head>
		<title>JSP for HelloForm form</title>
		<style type="text/css">body {font-size: 12px; }</style>
	</head>
	<body>
	
		您好，${ helloForm.name }.  <br/><br/>
		
		您的年龄是：${ helloForm.age },  <br/>
		
		<c:choose>
			<c:when test="${ helloForm.experience }">您以前用过 Struts。</c:when>
			<c:otherwise>您以前没有用过 Struts。</c:otherwise>
		</c:choose>
		
		<br/>
		
		您的爱好是：
		<c:forEach items="${ helloForm.hobby }" var="hobby">
			${ hobby }, 
		</c:forEach> <br/>
		日期：${ helloForm.date } <br/>
		时间：${ helloForm.time } <br/>

	</body>
</html>

