<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<jsp:directive.page import="com.helloweenvsfei.util.DbManager"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.Statement"/>
<jsp:directive.page import="java.sql.ResultSet"/>
<jsp:directive.page import="java.text.NumberFormat"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'listPerson.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
			body, td, th, input {font-size:12px; }
			table {border-collapse: collapse; border: 1px solid #000000}
			th, td {border: 1px solid #000000; padding: 2px; text-align: center; }
			.success {color: green; }
			.fail {color: red; }
		</style>
	</head>
	<body>
	
	<div style="padding: 2px; text-align: right; ">
		<a href="${ pageContext.request.requestURI }">只显示余额</a> | 
		<a href="${ pageContext.request.requestURI }?action=a2b">A向B转帐200元</a> |
		<a href="${ pageContext.request.requestURI }?action=b2a">B向A转帐200元</a>
	</div>
		
	<br/>
	<%
		String action = request.getParameter("action");
	
		if("a2b".equals(action)){
			
			out.println("业务：A向B转帐200元。<br/>");
			
			Connection conn = null;
			Statement stmt = null;
			try{
				conn = DbManager.getConnection();
				
				// 将自动提交设置为 false
				conn.setAutoCommit(false);
				
				stmt = conn.createStatement();
				
				int result1 = stmt.executeUpdate(" UPDATE tb_currency SET currency = currency - 200, last_modified = current_timestamp WHERE account = 'A' and currency >= 200 "); 
				
				out.println("A 帐号扣款 200 元，结果：" + (result1==1 ? "成功" : "失败") + "<br/>");
				
				int result2 = stmt.executeUpdate(" UPDATE tb_currency SET currency = currency + 200, last_modified = current_timestamp WHERE account = 'B' "); 
				
				out.println("B 帐号冲款 200 元，结果：" + (result2==1 ? "成功" : "失败") + "<br/>");
				
				if(result1 == 1 && result2 == 1){
					// 提交
					conn.commit();
					out.println("转帐成功，事务提交。<br/>");
				}
				else{
					// 回滚
					conn.rollback();
					out.println("转帐失败，事务回滚。<br/>");
				}
			}finally{
				if(stmt != null)	stmt.close();
				if(conn != null)	conn.close();
			}
			out.println("<br/>");
		}
		else if("b2a".equals(action)){
			
			out.println("业务：B向A转帐200元。<br/>");
			
			Connection conn = null;
			Statement stmt = null;
			try{
				conn = DbManager.getConnection();
				
				// 将自动提交设置为 false
				conn.setAutoCommit(false);
				stmt = conn.createStatement();

				int result1 = stmt.executeUpdate(" UPDATE tb_currency SET currency = currency - 200, last_modified = current_timestamp WHERE account = 'B' and currency >= 200 "); 
				out.println("B 帐号扣款 200 元，结果：" + (result1==1 ? "成功" : "失败") + "<br/>");
				
				int result2 = stmt.executeUpdate(" UPDATE tb_currency SET currency = currency + 200, last_modified = current_timestamp WHERE account = 'A' "); 
				out.println("A 帐号冲款 200 元，结果：" + (result2==1 ? "成功" : "失败") + "<br/>");
				
				if(result1 == 1 && result2 == 1){
					// 提交
					conn.commit();
					out.println("转帐成功，事务提交。<br/>");
				}
				else{
					// 回滚
					conn.rollback();
					out.println("转帐失败，事务回滚。<br/>");
				}
			}finally{
				if(stmt != null)	stmt.close();
				if(conn != null)	conn.close();
			}
			out.println("<br/>");
		}
	%>
	
	帐号余额：
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DbManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(" SELECT * FROM tb_currency WHERE account in ('A', 'B') ");
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("<table>");
			buffer.append("	<tr>");
			buffer.append("		<th>帐号</th>");
			buffer.append("		<th>余额</th>");
			buffer.append("		<th>最后修改日期</th>");
			buffer.append("	</tr>");
			while(rs.next()){
				buffer.append("	<tr>");
				buffer.append("		<td>" + rs.getString("account") + "</td>");
				buffer.append("		<th>" + NumberFormat.getCurrencyInstance().format(rs.getDouble("currency")) + "</td>");
				buffer.append("		<td>" + rs.getTimestamp("last_modified") + "</td>");
				buffer.append("	</tr>");
			}
			buffer.append("</table>");
			out.println(buffer);
		}finally{
			if(rs != null)	rs.close();
			if(stmt != null)	stmt.close();
			if(conn != null)	conn.close();
		}
	%>

	</body>
</html>
