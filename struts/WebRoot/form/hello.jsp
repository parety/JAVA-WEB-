<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for HelloForm form</title>
		<style type="text/css">body {font-size: 12px; }</style>
	</head>
	<body>
		<html:form action="/hello">
			姓名: <html:text property="name"/><b><html:errors property="name"/></b><br/>
			年龄: <html:text property="age" /><b><html:errors property="age"/></b><br/>
			是否用过Struts？: <html:checkbox property="experience" /> <br/>
			爱好: <html:checkbox property="hobby" value="音乐" /> 音乐
			<html:checkbox property="hobby" value="体育" /> 体育
			<html:checkbox property="hobby" value="影视" /> 影视 <b><html:errors property="hobby"/></b> <br/>
			日期：<html:text property="date"></html:text> <br/>
			时间：<html:text property="time"></html:text> <br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

