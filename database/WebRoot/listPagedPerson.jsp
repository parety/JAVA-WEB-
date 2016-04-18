<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<jsp:directive.page import="java.sql.Date"/>
<jsp:directive.page import="java.sql.Timestamp"/>
<jsp:directive.page import="java.sql.SQLException"/>
<jsp:directive.page import="com.helloweenvsfei.util.DbManager"/>
<jsp:directive.page import="java.sql.PreparedStatement"/>
<jsp:directive.page import="com.helloweenvsfei.util.Pagination"/>
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
<%
	final int pageSize = 10;	// 一页显示 10 条记录

	int pageNum = 1; 			// 当前页数
	int pageCount = 1;			// 总页数

	int recordCount = 0;		// 总记录数
	
	try{
		// 从地址栏参数取当前页数
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
	}catch(Exception e){}
	
	String sql = null;
	
	Connection conn = null;
	PreparedStatement preStmt = null;
	ResultSet rs = null;
	
	try{
		sql = "SELECT count(*) FROM tb_person ";
		
		recordCount = DbManager.getCount(sql);
		
		// 计算总页数
		pageCount = ( recordCount + pageSize - 1 ) / pageSize;
		// 本页从 startRecord 行开始
		int startRecord = ( pageNum - 1) * pageSize;
		
		// MySQL 使用limit实现分页
		sql = "SELECT * FROM tb_person LIMIT ?, ? ";
		
		conn = DbManager.getConnection();
		preStmt = conn.prepareStatement(sql);
		DbManager.setParams(preStmt, startRecord, pageSize);
		rs = preStmt.executeQuery();
%>
 <form action="operatePerson.jsp" method=get>
  <table bgcolor="#CCCCCC" cellspacing=1 cellpadding=5 width=100%>
  	<tr bgcolor=#DDDDDD>
  		<th>ID</th>
  		<th>姓名</th>
  		<th>英文名</th>
  		<th>性别</th>
  		<th>年龄</th>
  		<th>生日</th>
  		<th>备注</th>
  		<th>记录创建时间</th>
  		<th>操作</th>
  	</tr>
<%
		// 遍历结果集。rs.next() 返回结果集中是否还有下一条记录。如果有，自动滚动到下一条记录并返回 true
		while(rs.next()){
			
			int id = rs.getInt("id");	// 整形类型
			int age = rs.getInt("age");
			
			String name = rs.getString("name");	// 字符串类型
			String englishName = rs.getString("english_name");
			String sex = rs.getString("sex");
			String description = rs.getString("description");
			
			Date birthday = rs.getDate("birthday");	// 日期类型，只有日期信息而没有时间信息
			Timestamp createTime = rs.getTimestamp("create_time"); // 时间戳类型，既有日期又有时间。
	
			out.println("		<tr bgcolor=#FFFFFF>");
			out.println("			<td>" + id + "</td>");
			out.println("			<td>" + name + "</td>");
			out.println("			<td>" + englishName + "</td>");
			out.println("			<td>" + sex + "</td>");
			out.println("			<td>" + age + "</td>");
			out.println("			<td>" + birthday + "</td>");
			out.println("			<td>" + description + "</td>");
			out.println("			<td>" + createTime + "</td>");
			out.println("			<td>");
			out.println("				<a href='operatePerson.jsp?action=del&id=" + id + "' onclick='return confirm(\"确定删除记录？\"); '>删除</a>");
			out.println("				<a href='operatePerson.jsp?action=edit&id=" + id + "'>修改</a>");
			out.println("			</td>");
			out.println("		</tr>");
		}
%>
  </table>
  <table align=right><tr><td> <%= Pagination.getPagination(pageNum, pageCount, recordCount, request.getRequestURI()) %> </td></tr></table>
  <br/><br/><br/>
  <table align=left><tr><td>SQL: <%= sql %> </td></tr></table>
  </form>
<%
	}catch(SQLException e){
		out.println("执行SQL：" + sql + "时发生异常：" + e.getMessage());
		e.printStackTrace();
	}finally{
		if(rs != null)	rs.close();
		if(preStmt != null)	preStmt.close();
		if(conn != null)	conn.close();
	}
%>
  </body>
</html>
