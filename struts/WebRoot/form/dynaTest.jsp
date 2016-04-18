<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>

<html>
	<head>
		<title>JSP for DynaActionForm form</title>
	</head>
	<body>

		${ 'POST' == pageContext.request.method ? '提交后的数据' : '' }

		<html:form action="/dynaTest">
			年龄 : <html:text property="age" />
			<html:errors property="age" />
			<br />
			姓名 : <html:text property="name" />
			<html:errors property="name" />
			<br />
			生日 : <html:text property="birthday" />
			<html:errors property="birthday" />
			<br />
			<html:submit value="提交数据" />
		</html:form>
	</body>
</html>

