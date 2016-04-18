<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:directive.page import="javax.sql.DataSource" />
<jsp:directive.page import="javax.naming.Context"/>
<jsp:directive.page import="javax.naming.InitialContext"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.Statement"/>
<jsp:directive.page import="java.sql.ResultSet"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<sql:query var="rs" dataSource="jdbc/databaseWeb">
	select id, name, sex from tb_employee
</sql:query>

<html>
	<head>
		<title>DB Test</title>
	</head>
	<body>

		<h2>
			Results
		</h2>

		<c:forEach var="row" items="${rs.rows}">
		${ row['id'] },	${ row['name'] }, ${ row['sex'] }<br />
		</c:forEach>

		<%
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			
			DataSource ds = (DataSource) envContext.lookup("jdbc/databaseWeb");
			Connection conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id, name, sex from tb_employee");
			
			rs.close();
			stmt.close();
			conn.close();
		%>

	</body>
</html>

