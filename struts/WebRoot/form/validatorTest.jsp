<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for ValidatorTestForm form</title>
		<style type="text/css">
			body {font-size: 12px; }
		</style>
	</head>
	<body>
		<html:form action="/validatorTest" onsubmit="return validateValidatorTestForm(this); ">
			姓名: <html:text property="name"/><html:errors property="name"/><br/>
			年龄: <html:text property="age"/><html:errors property="age"/><br/>
			电子邮件: <html:text property="email"/><html:errors property="name"/><br/>
			<html:submit value="提交"/>
			<html:javascript formName="validatorTestForm" />
		</html:form>
	</body>
</html>

