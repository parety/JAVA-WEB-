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
	// ע�� Derby ���ݿ�����
	DriverManager.deregisterDriver(new EmbeddedDriver());

	// ��ȡ���ݿ�����
	Connection conn = DriverManager.getConnection("jdbc:derby:C:\\database_derby;create=true");
	
	// ���� Statement
	Statement stmt = conn.createStatement();
	
	try{
		// ʹ�� Statement ���󴴽����
		String sql = (" create table TB_TEST "
					+ " ( id integer GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
					+ "   ip varchar(100), "
					+ "   host varchar(100), "
					+ "   date timestamp, "
					+ "   primary key(id) )");

		System.out.println(sql);

		stmt.executeUpdate(sql); 		
					
		out.println("<div>�� tb_test ������. ������ tb_test �ɹ�. </div>");
		System.out.println("<div>�� tb_test ������. ������ tb_test �ɹ�. </div>");
		
	}catch(Exception e){
		out.println("<div>�� tb_test ����. </div>");
		System.out.println("<div>" + e.getMessage() + "</div>");
	}
	
	try{
		// ����һ������
		int rows = stmt.executeUpdate(" insert into tb_test ( ip, host, date ) "
					+ " values ('" + request.getRemoteAddr() + "', '" + request.getServerName() + "', current_timestamp ) ");
					
		out.println("<div>�²��� " + rows + " ������. </div>");
		System.out.println("<div>�²��� " + rows + " ������. </div>");
	}catch(Exception e){
		out.println("<div>��������ʧ�ܡ�ԭ��" + e.getMessage() + ". </div>");
		System.out.println("<div>��������ʧ�ܡ�ԭ��" + e.getMessage() + ". </div>");
	}
	
	// ��ȡ���м�¼
	ResultSet rs = null;
	
	try{
		rs = stmt.executeQuery(" select * from tb_test ");
	}catch(Exception e){
		out.println("<div>����ʧ�ܡ�ԭ��" + e.getMessage() + ". </div>");
	}
	
	out.println("<table border=1>");
	out.println("	<tr>");
	out.println("		<td width=100 align=center>���ʴ���</td>");
	out.println("		<td width=200 align=center>������ IP ��ַ</td>");
	out.println("		<td width=200 align=center>ʹ�õ�����</td>");
	out.println("		<td width=200 align=center>��������</td>");
	out.println("	</tr>");
	// ѭ�����������е����ݼ�
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
