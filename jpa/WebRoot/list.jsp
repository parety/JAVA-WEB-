<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<style type="text/css">
		th, td, body { font-size: 12px; }
		table {border-collapse: collapse; border: 1px solid #000000; }
		th, td {border: 1px solid #000000; }
		th { width: 100px; }
	</style>
	</head>

	<body>
	
		<a href="StudentServlet?action=add">添加随机记录</a>
		<a href="StudentServlet?action=list">所有记录列表</a> <br/><br/>

		<table>
			<tr>
				<th>
					Id
				</th>
				<th>
					Name
				</th>
				<th>
					Age
				</th>
			</tr>
			<c:forEach items="${ studentList }" var="student">
				<tr>
					<td>
						${ student.id }
					</td>
					<td>
						${ student.name }
					</td>
					<td>
						${ student.age }
					</td>
				</tr>
			</c:forEach>
		</table>



	</body>
</html>
