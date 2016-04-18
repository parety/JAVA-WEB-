<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested"
	prefix="nested"%>

<html>
	<head>
		<title>JSP for TagForm form</title>
		<style type="text/css">
		body {font-size: 12px; }
		</style>
	</head>
	<body>

		<fieldset>
			<legend>
				请填写表单，数据会被提交到 POJO 属性 person 中。
			</legend>

			<html:form action="/tile">
			action: <html:text property="action"></html:text>
				<br />
			帐号: <nested:text property="person.account"></nested:text>
				<br />
			姓名: <nested:text property="person.name"></nested:text>
				<br />
			生日: <nested:text property="person.birthday"></nested:text>
				<br />
			是否隐藏姓名: <nested:checkbox property="person.secret"></nested:checkbox>隐藏
				<br />
				<html:submit value="提交数据" />
				
			</html:form>

		</fieldset>

		<hr />

		<fieldset>
			<legend>
				显示 POJO 属性 person 的值
			</legend>


			<html:form action="/tile">
			action: <html:text property="action"></html:text>
				<br />
				<nested:nest property="person">
				当前层次：<nested:writeNesting />
					<br />
				帐号: <nested:text property="account"></nested:text>
					<br />
				姓名: <nested:text property="name"></nested:text>
					<br />
				生日: <nested:text property="birthday"></nested:text>
					<br />
				是否隐藏姓名: <nested:checkbox property="secret"></nested:checkbox>隐藏 <br />
					<nested:nest property="createDate">
					当前层次：<nested:writeNesting />
						<br />
					创建时间：<nested:text property="time"></nested:text>
						<br />
					</nested:nest>
				</nested:nest>

				<nested:root name="tileForm">
					<nested:text property="person.createDate.time"></nested:text>
				</nested:root>

			</html:form>

		</fieldset>

	</body>
</html>

