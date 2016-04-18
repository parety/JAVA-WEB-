<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.Statement"/>
<jsp:directive.page import="java.sql.ResultSet"/>
<jsp:directive.page import="java.sql.SQLException"/>
<jsp:directive.page import="com.helloweenvsfei.util.DbManager"/>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		textarea { width: 300px; height: 100px; font-size: 12px; }
		body {font-size: 12px; }
		table, td, th {font-size: 12px; }
		table {border-collapse: collapse; border: 1px solid #000000; }
		th {background: #CCCCCC; }
		td, th {border: 1px solid #000000; padding: 2px; text-align: center; padding-left:4px; padding-right:4px; }
		.error {font-size:12px; color:#FF0000; }
	</style>
  </head>
  
  <body>
  
  	<form action="${ pageContext.request.requestURL }" method="get">
  		<textarea name="sql">${ param.sql }</textarea> <input type="submit">
  	</form>
  
<%
	String sql = request.getParameter("sql");
	
	out.println("SQL语句：" + sql);

	if(sql != null && sql.trim().length() > 0){
	
	  	Connection conn = null;
	  	Statement stmt = null;
	  	ResultSet rs = null;
	  	
	  	try{
	  		conn = DbManager.getConnection();
	  		stmt = conn.createStatement();
	  		rs = stmt.executeQuery(sql);
	  		
	  		int columnCount = rs.getMetaData().getColumnCount();
	  		String[] columns = new String[columnCount];
	  		for(int i=1; i<=columnCount; i++){
	  			columns[i-1] = rs.getMetaData().getColumnLabel(i);
	  		}
	  		
	  		StringBuffer buffer = new StringBuffer();
	  		buffer.append("<table>");
	  		buffer.append("	<tr>");
	  		for(String column : columns){
	  			buffer.append("	<th>" + column + "</th>");
	  		}
	  		buffer.append("	</tr>");
	  		while(rs.next()){
	  			buffer.append("<tr>");
	  			for(String column : columns){
	  				buffer.append("<td>" + rs.getString(column) + "</td>");
	  			}
	  			buffer.append("</tr>");
	  		}
	  		buffer.append("</table>");
	  		
	  		out.println(buffer.toString());
	  		
	  	}catch(SQLException e){
	  		out.println("<div class=error>执行SQL：" + sql + "时出错：" + e.getMessage() + "</div>");
	  		e.printStackTrace();
	  	}finally{
	  		if(rs != null)	rs.close();
	  		if(stmt != null)	stmt.close();
	  		if(conn != null)	conn.close();
	  	}
  	}
%>
  
  </body>
</html>
