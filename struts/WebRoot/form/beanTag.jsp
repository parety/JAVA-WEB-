<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:directive.page import="com.helloweenvsfei.struts.bean.Person"/>
<jsp:directive.page import="java.sql.Timestamp"/>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%
	Person person = new Person();
	person.setName("张三");
	person.setCreateDate(new Timestamp(System.currentTimeMillis()));
	
	request.setAttribute("person", person);
%>
<html> 
	<head>
		<title>JSP for TagForm form</title>
		<style type="text/css">
		body {font-size: 12px; }
		</style>
	</head>
	<body>
	
		<bean:write name="person" />  t<br/>
		<bean:write name="person" property="createDate.time" />
		
		<bean:cookie id="sessionId" name="JSESSIONID"/>
		<bean:write name="sessionId" property="value"/>
		
		<bean:parameter id="action" name="action"/>
		<bean:write name="action"/>

		<bean:header id="host" name="host"/>	
		<bean:write name="host"/>
		
		<bean:message key="tag.info" arg0="张三" arg1="再见" />
		
		<bean:resource id="web_info" name="/WEB-INF/web.xml"/>
		<bean:write name="web_info"/>
		
		<bean:struts id="tagForm" formBean="tagForm" />
		<bean:struts id="tagMapping" mapping="/tag" />
		
		<bean:write name="tagForm" />
		
		<logic:present cookie="JSESSIONID">
			<bean:cookie id="sessionId" name="JSESSIONID"/>
			<bean:write name="sessionId" property="value"/>
		</logic:present>
		<logic:notPresent cookie="JSESSIONID">
			Cookie“JSESSIOND”不存在。
		</logic:notPresent>
		
		<logic:equal value="643BC9477FF8A4B0E" cookie="JSESSIONID"></logic:equal>
		
		<logic:greaterEqual value=""></logic:greaterEqual>
		<logic:greaterThan value=""></logic:greaterThan>
			
	</body>
</html>

