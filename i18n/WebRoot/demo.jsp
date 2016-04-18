<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

		<a href="${ pageContext.request.requestURI }?locale=en">English</a>
		<a href="${ pageContext.request.requestURI }?locale=zh_CN"><img
				src="images/zh_cn.gif" border=0 /> </a>
		<a href="${ pageContext.request.requestURI }?locale=zh_TW"><img
				src="images/zh_tw.gif" border=0 /> </a>
		<br />
		<br />

		<fmt:setLocale value="${ param.locale }" />

		<fmt:bundle basename="messages">

			<fmt:message key="helloworld"></fmt:message>
			<br />

			<fmt:message key="today"></fmt:message>

			<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
			<fmt:formatDate value="${ date }" type="both" />

		</fmt:bundle>
	</body>
</html>
