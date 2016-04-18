<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.ResultSet" %>
<jsp:directive.page import="java.sql.Date"/>
<jsp:directive.page import="java.sql.Timestamp"/>
<jsp:directive.page import="com.helloweenvsfei.util.DbManager"/>
<jsp:directive.page import="com.helloweenvsfei.util.Pagination"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.Statement"/>
<jsp:directive.page import="java.sql.SQLException"/>
<%!
	public String forSQL(String sql){
		return sql.replace("'", "\\'");
	}
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
	<style type="text/css">body, td, th{font-size:12px; text-align:center; }</style>
  </head>
  <body>
<%
	request.setCharacterEncoding("UTF-8");

	final int pageSize = 5;
	
	int pageNum = 1;
	
	try{
		pageNum = new Integer(request.getParameter("pageNum"));
	}catch(Exception e){}

	String nameSearch = request.getParameter("name");
	String sexSearch = request.getParameter("sex");
	String englishNameSearch = request.getParameter("englishName");
	String descriptionSearch = request.getParameter("description");
	String birthdayStart = request.getParameter("birthdayStart");
	String birthdayEnd = request.getParameter("birthdayEnd");
	
	String whereClause = "";
	
	// 模糊匹配
	if(nameSearch!=null && nameSearch.trim().length()!=0){
		if(whereClause.length() == 0)
			whereClause += " name LIKE '%" + forSQL(nameSearch) + "%'";
		else
			whereClause += " AND name LIKE '%" + forSQL(nameSearch) + "%'";
	}
	// 精确匹配
	if(sexSearch!=null && sexSearch.trim().length()!=0){
		if(whereClause.length() == 0)
			whereClause += " sex = '" + forSQL(sexSearch) + "' ";
		else
			whereClause += " AND sex = '" + forSQL(sexSearch) + "' ";
	}
	if(englishNameSearch!=null && englishNameSearch.trim().length()!=0){
		if(whereClause.length() == 0)
			whereClause += " english_name LIKE '%" + forSQL(englishNameSearch) + "%' ";
		else
			whereClause += " AND english_name LIKE '%" + forSQL(englishNameSearch) + "%' ";
	}
	if(descriptionSearch!=null && descriptionSearch.trim().length()!=0){
		if(whereClause.length() == 0)
			whereClause += " description LIKE '%" + forSQL(descriptionSearch) + "%' ";
		else
			whereClause += " AND description LIKE '%" + forSQL(descriptionSearch) + "%' ";
	}
	if(birthdayStart!=null && birthdayStart.trim().length()!=0){
		if(whereClause.length() == 0)
			whereClause += " birthday >= '" + birthdayStart + "' ";
		else
			whereClause += " AND birthday >= '" + birthdayStart + "' ";
	}
	if(birthdayEnd!=null && birthdayEnd.trim().length()!=0){
		if(whereClause.length() == 0)
			whereClause += " birthday <= '" + birthdayEnd + "' ";
		else
			whereClause += " AND birthday <= '" + birthdayEnd + "' ";
	}
	
	if(whereClause.length() != 0){
		whereClause = " WHERE " + whereClause;
	}
	
	String countSQL = " SELECT count(*) FROM tb_person " + whereClause;
	int recordCount = DbManager.getCount(countSQL); 
	
	int pageCount = (recordCount + pageSize) / pageSize;

	String querySQL = " SELECT * FROM tb_person " + whereClause + " LIMIT " + (pageNum-1)*pageSize + ", " + pageSize;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		conn = DbManager.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(querySQL);
%>
 <form action="searchPerson.jsp" method=get>
  <fieldset style='width:80%'>
  	<legend>查询条件</legend>
  	<table >
  		<tr>
  			<td style="text-align:right; ">姓名</td>
  			<td style="text-align:left; ">
  				<input type='text' name='name' value="${ param.name }"/>
  			</td>
  			<td style="text-align:right; ">性别</td>
  			<td style="text-align:left; ">
  				<select name='sex' />
  					<option value="">无限制</option>
  					<option value="男" ${ '男'==param.sex ? 'selected' : '' }>男</option>
  					<option value="女" ${ '女'==param.sex ? 'selected' : '' }>女</option>
  				</select>
  			</td>
  		</tr>
  		<tr>
  			<td style="text-align:right; ">英文名</td>
  			<td style="text-align:left; ">
  				<input type='text' name='englishName' value="${ param.englishName }"/>
  			</td>
  			<td style="text-align:right; ">备注</td>
  			<td style="text-align:left; ">
  				<input type='text' name='description' value="${ param.description }"/>
  			</td>
  		</tr>
  		<tr>
  			<td colspan=4>
  				出生日期
  				从 <input type='text' name='birthdayStart' onfocus="setday(birthdayStart);" value="${ param.birthdayStart }"/>
  				<img src="images/calendar.gif" onclick="setday(birthdayStart);" />&nbsp;&nbsp;
  				到 <input type='text' name='birthdayEnd' onfocus="setday(birthdayEnd);" value="${ param.birthdayEnd }"/>
  				<img src="images/calendar.gif" onclick="setday(birthdayEnd);" />
  			</td>
  		</tr>
  		<tr>
  			<td colspan=4>
  				<input type="submit" value="提交查询">
  				<input type="reset" value="复位">
  			</td>
  		</tr>
  	</table>
  </fieldset>
  <br/>
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
		out.println("		</tr>");
	}
%>
  </table>
  <table align=right><tr><td>
  	<%= Pagination.getPagination(pageNum, pageCount, recordCount, request.getRequestURI()) %>
  </td></tr></table><br/><br/>
  <table width='100%'><tr><td style='text-align:center; '>
  	<br/><br/> <%= "Count SQL: " + countSQL %>
  	<br/><br/> <%= "Query SQL: " + querySQL %>
  </td></tr></table>
  </form>
<%
	}catch(SQLException e){
		out.println("执行SQL：" + querySQL + "时出错：" + e.getMessage());
	}finally{
		if(rs != null)	rs.close();
		if(stmt != null)	stmt.close();
		if(conn != null)	conn.close();
	}
%>
  <script type="text/javascript" src="js/calendar.js"></script>
  </body>
</html>
