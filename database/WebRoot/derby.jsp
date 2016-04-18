<%@ page language="java" pageEncoding="GB18030"%>
<jsp:directive.page import="org.apache.derby.jdbc.EmbeddedDriver"/>
<jsp:directive.page import="java.sql.DriverManager"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.Statement"/>
<jsp:directive.page import="java.sql.ResultSet"/>
<jsp:directive.page import="java.sql.SQLException"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'derby.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">td, div{font-size:12px; } div{line-height:22px; }</style>
  </head>
  
  <body>
<%
	// 注册 Derby 数据库驱动
	DriverManager.deregisterDriver(new EmbeddedDriver());

	// 获取数据库连接
	Connection conn = DriverManager.getConnection("jdbc:derby:C:\\database_derby;create=true");
	
	// 创建 Statement
	Statement stmt = conn.createStatement();
	
	try{
		// 使用 Statement 对象创建表格
		String sql = (" create table TB_TEST "
					+ " ( id integer GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
					+ "   ip varchar(100), "
					+ "   host varchar(100), "
					+ "   date timestamp, "
					+ "   primary key(id) )");

		System.out.println(sql);

		stmt.executeUpdate(sql); 		
					
		out.println("<div>表 tb_test 不存在. 创建表 tb_test 成功. </div>");
		System.out.println("<div>表 tb_test 不存在. 创建表 tb_test 成功. </div>");
		
	}catch(Exception e){
		out.println("<div>表 tb_test 存在. </div>");
		System.out.println("<div>" + e.getMessage() + "</div>");
	}
	
	try{
		// 插入一条数据
		int rows = stmt.executeUpdate(" insert into tb_test ( ip, host, date ) "
					+ " values ('" + request.getRemoteAddr() + "', '" + request.getServerName() + "', current_timestamp ) ");
					
		out.println("<div>新插入 " + rows + " 行数据. </div>");
		System.out.println("<div>新插入 " + rows + " 行数据. </div>");
	}catch(Exception e){
		out.println("<div>插入数据失败。原因：" + e.getMessage() + ". </div>");
		System.out.println("<div>插入数据失败。原因：" + e.getMessage() + ". </div>");
	}
	
	// 获取所有记录
	ResultSet rs = null;
	
	try{
		rs = stmt.executeQuery(" select * from tb_test ");
	}catch(Exception e){
		out.println("<div>数据失败。原因：" + e.getMessage() + ". </div>");
	}
	
	out.println("<table border=1>");
	out.println("	<tr>");
	out.println("		<td width=100 align=center>访问次序</td>");
	out.println("		<td width=200 align=center>访问者 IP 地址</td>");
	out.println("		<td width=200 align=center>使用的域名</td>");
	out.println("		<td width=200 align=center>访问日期</td>");
	out.println("	</tr>");
	// 循环遍历完所有的数据集
	while(rs != null && rs.next()){
		out.println("	<tr>");
		out.println("		<td align=center>" + rs.getInt("id") + "</td>");
		out.println("		<td align=center>" + rs.getString("ip") + "</td>");
		out.println("		<td align=center>" + rs.getString("host") + "</td>");
		out.println("		<td align=center>" + rs.getTimestamp("date") + "</td>");
		out.println("	</tr>");
	}
	out.println("</table>");
	
	if(rs != null)
		rs.close();
	if(stmt != null)
		stmt.close();
	if(conn != null)
		conn.close(); 
	
%>
  </body>
</html>
