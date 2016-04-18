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
		<style type="text/css">
		body {font-size: 12px; }
		</style>
	</head>

	<body>
	
		<!-- 设置 Locale, 测试用
		<fmt:setLocale value="zh_CN"/>
		 -->
		<fmt:bundle basename="com.helloweenvsfei.i18n.param">
			<fmt:message key="hello">
				<fmt:param value="${ pageContext.request.remoteAddr }" />
				<fmt:param value="${ pageContext.request.locale }" />
				<fmt:param value="${ pageContext.request.locale.displayLanguage }" />
			</fmt:message>
		</fmt:bundle>
	</body>
</html>
