<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page import="com.helloweenvsfei.dao.EmployeeDAO"/>
<jsp:directive.page import="java.util.List"/>
<%
	List employeeList = EmployeeDAO.listAllEmployees();
	request.setAttribute("employeeList", employeeList);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'listPerson.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">body, td, th, input {font-size:12px; text-align:center; }</style>
	</head>
	<body>
		<table align=right>
			<tr>
				<td>
					<a href="addDepartment.jsp">新建部门</a>
					<a href="addEmployee.jsp">新建员工资料</a>
				</td>
			</tr>
		</table>
		<br />
		<br />
		<form action="operatePerson.jsp" method=get>
			<table bgcolor="#CCCCCC" cellspacing=1 cellpadding=5 width=100%>
				<tr bgcolor=#DDDDDD>
					<th></th>
					<th>ID</th>
					<th>姓名</th>
					<th>部门</th>
					<th>性别</th>
					<th>入职日期</th>
					<th>操作</th>
				</tr>
				
				<c:forEach items="${ employeeList }" var="employee">
					<tr bgcolor="#FFFFFF">
						<td><input type="checkbox" name="id" value="${ employee.id }" /></td>
						<td>${ employee.id }</td>
						<td>${ employee.name }</td>
						<td>${ employee.department.name }</td>
						<td>${ employee.sex }</td>
						<td>${ employee.employedDate }</td>
						<td>
							<a href="addEmployee.jsp?action=edit&id=${ employee.id }">修改</a>
							<a href="addEmployee.jsp?action=del&id=${ employee.id }" onclick="return confirm('确定删除?')">删除</a>
						</td>
					</tr>
				</c:forEach>
				
			</table>
			<table align=left>
				<tr>
					<td>
						<input type='hidden' value='del' name='action'>
						<a href='#'
							onclick="var array=document.getElementsByName('id');for(var i=0; i<array.length;
							i++){array[i].checked=true;}">全选</a>
						<a href='#'
							onclick="var array=document.getElementsByName('id');for(var i=0; i<array.length;
							i++){array[i].checked=false;}">取消全选</a>
						<input type='submit'
							onclick="return confirm('即将删除所选择的记录。是否删除？'); " value='删除'>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
