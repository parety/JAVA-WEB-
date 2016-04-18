<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.ResultSet" %>
<jsp:directive.page import="java.sql.Date"/>
<jsp:directive.page import="java.sql.Timestamp"/>
<jsp:directive.page import="com.helloweenvsfei.util.DbManager"/>
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
	<style type="text/css">body, td, input {font-size:12px; text-align:center; }</style>
  </head>
  <body>
  
<%
	final int pageSize = 5;
	
	int pageNum = 1;
	
	try{
		pageNum = new Integer(request.getParameter("pageNum"));
	}catch(Exception e){}

	DbManager dbManager = new DbManager();
	dbManager.connect("databaseWeb", "root", "admin");
	
	int recordCount = dbManager.getCount(" SELECT count(*) FROM tb_person "); 
	int pageCount = (recordCount + pageSize) / pageSize;

	ResultSet rs = dbManager.executeQuery("select * from tb_person LIMIT " + (pageNum-1)*pageSize + ", " + pageSize);
	
%>
 <form action="operatePerson.jsp" method=get>
  <table bgcolor="#CCCCCC" cellspacing=1 cellpadding=5 width=100%>
  	<tr bgcolor=#DDDDDD>
  		<td></td>
  		<td>ID</td>
  		<td>姓名</td>
  		<td>英文名</td>
  		<td>性别</td>
  		<td>年龄</td>
  		<td>生日</td>
  		<td>备注</td>
  		<td>记录创建时间</td>
  		<td>操作</td>
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
		out.println("			<td><input type=checkbox name=id value=" + id + "></td>");
		out.println("			<td>" + id + "</td>");
		out.println("			<td>" + name + "</td>");
		out.println("			<td>" + englishName + "</td>");
		out.println("			<td>" + sex + "</td>");
		out.println("			<td>" + age + "</td>");
		out.println("			<td>" + birthday + "</td>");
		out.println("			<td>" + description + "</td>");
		out.println("			<td>" + createTime + "</td>");
		out.println("			<td>");
		out.println("				<a href='operatePerson.jsp?action=del&id=" + id + "'>删除</a>");
		out.println("				<a href='operatePerson.jsp?action=edit&id=" + id + "'>修改</a>");
		out.println("			</td>");
		out.println("		</tr>");
		
	}
%>
  </table>
  <table align=right><tr><td>
  	<%= Pagination.getPagination(pageNum, pageCount, recordCount, request.getRequestURI()) %>
  </td></tr></table>
  </form>
<%
	dbManager.close();
%>
  </body>
</html>
