<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
 
<html> 
	<head>
		<title>JSP for PersonForm form</title>
		<style type="text/css">
		body, th, td {font-size: 12px; }
		table {border-collapse: collapse; border: 1px solid #000000; }
		th, td {border: 1px solid #000000; padding: 2px; }
		</style>
	</head>
	<body>
		<table>
			<tr>
				<th>ID</th>
				<th>帐号</th>
				<th>姓名</th>
				<th>生日</th>
				<th>爱好</th>
				<th>是否隐藏姓名</th>
			</tr>
			<logic:iterate id="person" name="personList">
				<tr>
					<td><bean:write name="person" property="id" /></td>
					<td><bean:write name="person" property="account" /></td>
					<td>
						<logic:equal value="false" name="person" property="secret">
							<bean:write name="person" property="name" />
						</logic:equal>
						<logic:equal value="true" name="person" property="secret">
							***
						</logic:equal>
					</td>
					<td><bean:write name="person" property="birthday" /></td>
					<td>
						<logic:iterate id="hobby" name="person" property="hobby">
							<bean:write name="hobby"/>, 
						</logic:iterate>
					</td>
					<td><bean:write name="person" property="secret" /></td>
				</tr>
			</logic:iterate>
		</table>
		
		<br/>
		
		<a href="${ pageContext.request.contextPath }/form/addPerson.jsp">添加人员</a>
	</body>
</html>

