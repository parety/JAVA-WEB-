<%@ page language="java" pageEncoding="GB18030"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for UseBeanForm form</title>
	</head>
	<body>
		<html:form action="/useBean">
			action: <html:text property="action"></html:text> <br/>
			account: <html:text property="person.account"></html:text> <br/>
			name : <html:text property="person.name"></html:text> <br/>
			<br/>
			<br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

