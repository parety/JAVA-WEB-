<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<jsp:directive.page import="java.sql.Date" />
<jsp:directive.page import="java.sql.Timestamp" />
<jsp:directive.page import="java.sql.SQLException"/>
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
					<a href="addPerson.jsp">新建人员资料</a>
				</td>
			</tr>
		</table>
		<br />
		<br />
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		// 注册 MySQL 驱动. 也可以使用下面两种方式的任一种
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//new com.mysql.jdbc.Driver();
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		// 获取数据库连接。 三个参数分别为 连接URL，用户名，密码
		conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/databaseWeb", 
							"root", 
							"admin");
		
		// 获取 Statement。 Statement 对象用于执行 SQL。相当于控制台。
		stmt = conn.createStatement();
		
		// 使用 Statement 执行 SELECT 语句。返回结果集。
		rs = stmt.executeQuery("select * from tb_person");	
%>
		<form action="operatePerson.jsp" method=get>
			<table bgcolor="#CCCCCC" cellspacing=1 cellpadding=5 width=100%>
				<tr bgcolor=#DDDDDD>
					<th></th>
					<th>
						ID
					</th>
					<th>
						姓名
					</th>
					<th>
						英文名
					</th>
					<th>
						性别
					</th>
					<th>
						年龄
					</th>
					<th>
						生日
					</th>
					<th>
						备注
					</th>
					<th>
						记录创建时间
					</th>
					<th>
						操作
					</th>
				</tr>
				<%
					// 遍历结果集。rs.next() 返回结果集中是否还有下一条记录。如果有，自动滚动到下一条记录并返回 true
					while (rs.next()) {

						int id = rs.getInt("id"); // 整形类型
						int age = rs.getInt("age");

						String name = rs.getString("name"); // 字符串类型
						String englishName = rs.getString("english_name");
						String sex = rs.getString("sex");
						String description = rs.getString("description");

						Date birthday = rs.getDate("birthday"); // 日期类型，只有日期信息而没有时间信息
						Timestamp createTime = rs.getTimestamp("create_time"); // 时间戳类型，既有日期又有时间。

						out.println("		<tr bgcolor=#FFFFFF>");
						out.println("	<td><input type=checkbox name=id value=" + id
						+ "></td>");
						out.println("	<td>" + id + "</td>");
						out.println("	<td>" + name + "</td>");
						out.println("	<td>" + englishName + "</td>");
						out.println("	<td>" + sex + "</td>");
						out.println("	<td>" + age + "</td>");
						out.println("	<td>" + birthday + "</td>");
						out.println("	<td>" + description + "</td>");
						out.println("	<td>" + createTime + "</td>");
						out.println("	<td>");
						out.println("		<a href='operatePerson.jsp?action=del&id="
						+ id + "' onclick='return confirm(\"确定删除该记录？\")'>删除</a>");
						out.println("		<a href='operatePerson.jsp?action=edit&id="
						+ id + "'>修改</a>");
						out.println("	</td>");
						out.println("		</tr>");

					}
				%>
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
<%
	}catch(SQLException e){
		out.println("发生了异常：" + e.getMessage());
		e.printStackTrace();
	}finally{
			// 关闭
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
	}
%>
	</body>
</html>
